package pl.ukaszapps.curricullumvitae.view.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import pl.ukaszapps.curricullumvitae.domain.data.CVDataRepository
import pl.ukaszapps.curricullumvitae.view.model.*

class ExperienceViewModel(private val repository: CVDataRepository) : ViewModel() {
    val experience: LiveData<ResultState<List<Project>>> = liveData {
        emit(Loading())
        try {
            val data = repository.getProjects()
            emit(
                Value( 
                    data.projects.map {
                        Project(
                            name = it.name,
                            from = it.from,
                            to = it.to,
                            skills = it.skillsUsed.map { skillName -> skillName.toSkillResource() }.filterNot { it == SKILL_PLACEHOLDER },
                            company = it.company
                        )
                    }
                )
            )
        } catch (e: Exception) {
            emit(Error(errorMessage = "Unable to receive data"))
        }
    }
}