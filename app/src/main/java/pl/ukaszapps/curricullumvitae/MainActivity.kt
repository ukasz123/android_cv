package pl.ukaszapps.curricullumvitae

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.compose.unaryPlus
import androidx.lifecycle.*
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.ui.core.Text
import androidx.ui.core.dp
import androidx.ui.core.setContent
import androidx.ui.foundation.VerticalScroller
import androidx.ui.graphics.Color
import androidx.ui.layout.Column
import androidx.ui.layout.FlexColumn
import androidx.ui.layout.Padding
import androidx.ui.material.MaterialColors
import androidx.ui.material.MaterialTheme
import androidx.ui.material.TopAppBar
import androidx.ui.material.themeColor
import androidx.ui.res.stringResource
import androidx.ui.tooling.preview.Preview
import com.google.android.material.button.MaterialButton
import pl.ukaszapps.curricullumvitae.view.adapters.ExperienceAdapter
import pl.ukaszapps.curricullumvitae.view.adapters.OwnProjectsAdapter
import pl.ukaszapps.curricullumvitae.view.adapters.SkillsAdapter
import pl.ukaszapps.curricullumvitae.view.composables.ContactData
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

        val contactDataViewModel = viewModelProvider[ContactDataViewModel::class.java]
//
//        contactDataViewModel.address.observe(owner = this) { resultState ->
//            when (resultState) {
//                is Error -> {
//                    city.text = resultState.errorMessage
//                    city.setTextColor(resources.getColor(R.color.errorColor))
//                }
//                is Value -> {
//                    city.text = resultState.value
//                    city.setTextColor(resources.getColor(R.color.primaryTextColor))
//                }
//            }
//        }
        setContent {
            MyCVApp {
                ContactData(lifecycleOwner = this, infoLiveData = contactDataViewModel.infoLiveData)
            }
        }
//        setContentView(R.layout.activity_main)
//
//        val skills = findViewById<RecyclerView>(R.id.skillsRecyclerView).apply {
//            layoutManager?.isAutoMeasureEnabled = false
//        }
//        val skillsAdapter = SkillsAdapter(layoutInflater)
//        skills.adapter = skillsAdapter
//        val skillsViewModel = viewModelProvider[SkillsViewModel::class.java]
//        skillsViewModel.skills.observe(this, skillsAdapter)
//
//        val experience = findViewById<RecyclerView>(R.id.experienceRecyclerView).apply {
//            layoutManager?.isAutoMeasureEnabled = false
//            addItemDecoration(
//                DividerItemDecoration(
//                    context,
//                    LinearLayoutManager.VERTICAL
//                )
//            )
//        }
//        val experienceAdapter = ExperienceAdapter(layoutInflater)
//        experience.adapter = experienceAdapter
//        val experienceViewModel = viewModelProvider[ExperienceViewModel::class.java]
//        experienceViewModel.experience.observe(this, experienceAdapter)
//
//        val ownProjects = findViewById<RecyclerView>(R.id.ownProjectsRecyclerView).apply {
//            layoutManager?.isAutoMeasureEnabled = false
//            addItemDecoration(
//                DividerItemDecoration(
//                    context,
//                    LinearLayoutManager.VERTICAL
//                )
//            )
//        }
//        val ownProjectsAdapter = OwnProjectsAdapter(layoutInflater)
//        ownProjects.adapter = ownProjectsAdapter
//        val ownProjectsViewModel = viewModelProvider[OwnProjectsViewModel::class.java]
//        ownProjectsViewModel.ownProjects.observe(this, ownProjectsAdapter)
//
//        val contactDataViewModel = viewModelProvider[ContactDataViewModel::class.java]
//
//        val city = findViewById<TextView>(R.id.location_text)
//        contactDataViewModel.address.observe(owner = this) { resultState ->
//            when (resultState) {
//                is Error -> {
//                    city.text = resultState.errorMessage
//                    city.setTextColor(resources.getColor(R.color.errorColor))
//                }
//                is Value -> {
//                    city.text = resultState.value
//                    city.setTextColor(resources.getColor(R.color.primaryTextColor))
//                }
//            }
//        }
//        bindSocialButton(findViewById(R.id.social_linkedIn), contactDataViewModel.linkedInUrl)
//        bindSocialButton(findViewById(R.id.social_bitbucket), contactDataViewModel.bitbucketUrl)
//        bindSocialButton(findViewById(R.id.social_github), contactDataViewModel.githubUrl)
    }

    @Composable
    fun MyCVApp(children: @Composable() () -> Unit) {

        val primaryColor = Color(0xff3949ab)
        val primaryLightColor = Color(0xff6f74dd)
        val primaryDarkColor = Color(0xff00227b)
        val secondaryColor = Color(0xffffcc80)
        val secondaryLightColor = Color(0xffffffb0)
        val secondaryDarkColor = Color(0xffca9b52)
        val primaryTextColor = Color(0xffffffff)
        val secondaryTextColor = Color(0xff000000)
        val errorColor = Color(0xffA64932)
        val themeColors = MaterialColors(
            primary = primaryColor,
            secondary = secondaryColor,
            primaryVariant = primaryDarkColor,
            secondaryVariant = secondaryLightColor,
            onPrimary = primaryTextColor,
            onSecondary = secondaryTextColor,
            error = errorColor,
            onError = Color.White
        )
        MaterialTheme(colors = themeColors) {
            FlexColumn {
                inflexible {
                    TopAppBar(
                        title = { Text(text = +stringResource(R.string.full_name)) }
                    )
                }
                flexible(flex = 1f) {
                    VerticalScroller {
                        Padding(left = 16.dp, right = 16.dp) {
                            Column {
                                children()
                            }
                        }
                    }
                }
            }

        }
    }

    @Preview
    @Composable
    fun DefaultPreview() {
        MyCVApp {
            Text(text = "ABC")
        }
    }

    private fun bindSocialButton(
        button: MaterialButton,
        urlLiveData: LiveData<ResultState<String>>
    ) {
        urlLiveData.observe(this,
            Observer<ResultState<String>> { resultState ->
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
            })
    }
}
