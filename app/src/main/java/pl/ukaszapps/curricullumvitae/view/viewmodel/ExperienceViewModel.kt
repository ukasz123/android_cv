package pl.ukaszapps.curricullumvitae.view.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import kotlinx.coroutines.delay
import pl.ukaszapps.curricullumvitae.domain.data.CVDataRepository
import pl.ukaszapps.curricullumvitae.view.model.Loading
import pl.ukaszapps.curricullumvitae.view.model.Project
import pl.ukaszapps.curricullumvitae.view.model.ResultState
import pl.ukaszapps.curricullumvitae.view.model.Value

class ExperienceViewModel(private val repository: CVDataRepository) : ViewModel() {
    val experience: LiveData<ResultState<List<Project>>> = liveData {
        emit(Loading())
        delay(2_000)
        val data = repository.getProjects()
        emit(
            Value(
                data.projects.map {
                    Project(
                        name = it.name,
                        from = it.from,
                        to = it.to,
                        skills = it.skillsUsed.map { skillName -> skillName.toSkillResource() },
                        company = it.company
                    )
                }
            )
        )
    }
}