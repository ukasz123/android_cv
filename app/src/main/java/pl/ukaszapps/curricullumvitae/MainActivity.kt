package pl.ukaszapps.curricullumvitae

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import pl.ukaszapps.curricullumvitae.view.adapters.ExperienceAdapter
import pl.ukaszapps.curricullumvitae.view.adapters.OwnProjectsAdapter
import pl.ukaszapps.curricullumvitae.view.adapters.SkillsAdapter
import pl.ukaszapps.curricullumvitae.view.model.OwnProject
import pl.ukaszapps.curricullumvitae.view.model.Project
import pl.ukaszapps.curricullumvitae.view.model.Skill
import pl.ukaszapps.curricullumvitae.view.model.Value


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val skills = findViewById<RecyclerView>(R.id.skillsRecyclerView).apply {
            layoutManager?.isAutoMeasureEnabled = false
        }
        skills.adapter = SkillsAdapter(layoutInflater).apply {
            state = Value(
                listOf(
                    Skill(name = "flutter", icon = R.drawable.ic_location_city, level = 4),
                    Skill(name = "android", icon = R.drawable.ic_error_outline, level = 3),
                    Skill(name = "dart", icon = R.drawable.ic_location_city, level = 4),
                    Skill(name = "git", icon = R.drawable.ic_location_city, level = 1),
                    Skill(name = "java", icon = R.drawable.ic_error_outline, level = 10)
                )
            )
        }

        val experience = findViewById<RecyclerView>(R.id.experienceRecyclerView).apply {
            layoutManager?.isAutoMeasureEnabled = false
            addItemDecoration(
                DividerItemDecoration(
                    context,
                    LinearLayoutManager.VERTICAL
                )
            )
        }
        experience.adapter = ExperienceAdapter(layoutInflater).apply {
            state = Value(
                listOf(
                    Project(
                        name = "abc",
                        company = "def",
                        from = "2018-09",
                        skills = listOf(R.drawable.ic_error_outline, R.drawable.ic_location_city)
                    ),
                    Project(
                        name = "Awesome project",
                        company = "Awesome",
                        from = "2017-09",
                        to = "2018-08",
                        skills = listOf(
                            R.drawable.ic_error_outline,
                            R.drawable.ic_location_city,
                            R.drawable.ic_error_outline
                        )
                    ),
                    Project(
                        name = "Even moreAwesome project",
                        company = "Awesome",
                        from = "2016-09",
                        to = "2017-08",
                        skills = listOf(
                            R.drawable.ic_error_outline,
                            R.drawable.ic_location_city,
                            R.drawable.ic_error_outline,
                            R.drawable.ic_error_outline,
                            R.drawable.ic_location_city,
                            R.drawable.ic_error_outline,
                            R.drawable.ic_error_outline,
                            R.drawable.ic_location_city,
                            R.drawable.ic_error_outline,
                            R.drawable.ic_error_outline,
                            R.drawable.ic_location_city,
                            R.drawable.ic_error_outline,
                            R.drawable.ic_error_outline,
                            R.drawable.ic_location_city,
                            R.drawable.ic_error_outline,
                            R.drawable.ic_error_outline,
                            R.drawable.ic_location_city,
                            R.drawable.ic_error_outline,
                            R.drawable.ic_error_outline,
                            R.drawable.ic_location_city,
                            R.drawable.ic_error_outline,
                            R.drawable.ic_error_outline,
                            R.drawable.ic_location_city,
                            R.drawable.ic_error_outline
                        )
                    )
                )
            )
        }

        val ownProjects = findViewById<RecyclerView>(R.id.ownProjectsRecyclerView).apply {
            layoutManager?.isAutoMeasureEnabled = false
            addItemDecoration(
                DividerItemDecoration(
                    context,
                    LinearLayoutManager.VERTICAL
                )
            )
        }
        ownProjects.adapter = OwnProjectsAdapter(layoutInflater).apply {
            state = Value(
                listOf(
                    OwnProject(
                        name = "Soundpool",
                        description = "Plugin for Flutter inspired by Sound Pool API for Android. The goal of this plugin is to provide a way for caching sounds in memory before playing.",
                        skillsUsed = emptyList()
                    ),
                    OwnProject(
                        name = "Soundpool",
                        description = "Plugin for Flutter inspired by Sound Pool API for Android. The goal of this plugin is to provide a way for caching sounds in memory before playing.",
                        skillsUsed = listOf(
                            R.drawable.ic_location_city, R.drawable.ic_error_outline
                        )
                    )
                )
            )
        }
    }
}
