package pl.ukaszapps.curricullumvitae

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import pl.ukaszapps.curricullumvitae.view.adapters.ExperienceAdapter
import pl.ukaszapps.curricullumvitae.view.adapters.OwnProjectsAdapter
import pl.ukaszapps.curricullumvitae.view.adapters.SkillsAdapter
import pl.ukaszapps.curricullumvitae.view.model.OwnProject
import pl.ukaszapps.curricullumvitae.view.model.Project
import pl.ukaszapps.curricullumvitae.view.model.Value
import pl.ukaszapps.curricullumvitae.view.viewmodel.ExperienceViewModel
import pl.ukaszapps.curricullumvitae.view.viewmodel.OwnProjectsViewModel
import pl.ukaszapps.curricullumvitae.view.viewmodel.SkillsViewModel


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val skills = findViewById<RecyclerView>(R.id.skillsRecyclerView).apply {
            layoutManager?.isAutoMeasureEnabled = false
        }
        val skillsAdapter = SkillsAdapter(layoutInflater)
        skills.adapter = skillsAdapter
        val skillsViewModel = ViewModelProviders.of(this)[SkillsViewModel::class.java]
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
        val experienceAdapter  = ExperienceAdapter(layoutInflater)
        experience.adapter = experienceAdapter
        val experienceViewModel = ViewModelProviders.of(this)[ExperienceViewModel::class.java]
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
        val ownProjectsViewModel = ViewModelProviders.of(this)[OwnProjectsViewModel::class.java]
        ownProjectsViewModel.ownProjects.observe(this, ownProjectsAdapter)
    }
}
