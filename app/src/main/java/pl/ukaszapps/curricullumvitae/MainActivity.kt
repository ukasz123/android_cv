package pl.ukaszapps.curricullumvitae

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.observe
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton
import pl.ukaszapps.curricullumvitae.view.adapters.ExperienceAdapter
import pl.ukaszapps.curricullumvitae.view.adapters.OwnProjectsAdapter
import pl.ukaszapps.curricullumvitae.view.adapters.SkillsAdapter
import pl.ukaszapps.curricullumvitae.view.model.Value
import pl.ukaszapps.curricullumvitae.view.model.Error
import pl.ukaszapps.curricullumvitae.view.model.ResultState
import pl.ukaszapps.curricullumvitae.view.showUrl
import pl.ukaszapps.curricullumvitae.view.viewmodel.ContactDataViewModel
import pl.ukaszapps.curricullumvitae.view.viewmodel.ExperienceViewModel
import pl.ukaszapps.curricullumvitae.view.viewmodel.OwnProjectsViewModel
import pl.ukaszapps.curricullumvitae.view.viewmodel.SkillsViewModel


class MainActivity : AppCompatActivity() {

    internal val viewModelProvider: ViewModelProvider by lazy {
        ViewModelProviders.of(this, viewModelFactory)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val skills = findViewById<RecyclerView>(R.id.skillsRecyclerView).apply {
            layoutManager?.isAutoMeasureEnabled = false
        }
        val skillsAdapter = SkillsAdapter(layoutInflater)
        skills.adapter = skillsAdapter
        val skillsViewModel = viewModelProvider[SkillsViewModel::class.java]
        skillsViewModel.skills.observe(this, skillsAdapter)

        val experience = findViewById<RecyclerView>(R.id.experienceRecyclerView).apply {
            layoutManager?.isAutoMeasureEnabled = false
            addItemDecoration(
                DividerItemDecoration(
                    context,
                    LinearLayoutManager.VERTICAL
                )
            )
        }
        val experienceAdapter = ExperienceAdapter(layoutInflater)
        experience.adapter = experienceAdapter
        val experienceViewModel = viewModelProvider[ExperienceViewModel::class.java]
        experienceViewModel.experience.observe(this, experienceAdapter)

        val ownProjects = findViewById<RecyclerView>(R.id.ownProjectsRecyclerView).apply {
            layoutManager?.isAutoMeasureEnabled = false
            addItemDecoration(
                DividerItemDecoration(
                    context,
                    LinearLayoutManager.VERTICAL
                )
            )
        }
        val ownProjectsAdapter = OwnProjectsAdapter(layoutInflater)
        ownProjects.adapter = ownProjectsAdapter
        val ownProjectsViewModel = viewModelProvider[OwnProjectsViewModel::class.java]
        ownProjectsViewModel.ownProjects.observe(this, ownProjectsAdapter)

        val contactDataViewModel = viewModelProvider[ContactDataViewModel::class.java]

        val city = findViewById<TextView>(R.id.location_text)
        contactDataViewModel.address.observe(owner = this) { resultState ->
            when (resultState) {
                is Error -> {
                    city.text = resultState.errorMessage
                    city.setTextColor(resources.getColor(R.color.errorColor))
                }
                is Value -> {
                    city.text = resultState.value
                    city.setTextColor(resources.getColor(R.color.primaryTextColor))
                }
            }
        }
        bindSocialButton(findViewById(R.id.social_linkedIn), contactDataViewModel.linkedInUrl)
        bindSocialButton(findViewById(R.id.social_bitbucket), contactDataViewModel.bitbucketUrl)
        bindSocialButton(findViewById(R.id.social_github), contactDataViewModel.githubUrl)
    }

    private fun bindSocialButton(button: MaterialButton, urlLiveData: LiveData<ResultState<String>>) {
        urlLiveData.observe(owner = this){ resultState ->
            when (resultState) {
                is Value -> {
                    button.isEnabled = true
                    button.setOnClickListener {
                        showUrl(resultState.value)
                    }
                }
                else -> {
                    button.isEnabled = false
                    button.setOnClickListener(null)
                }
            }
        }
    }
}
