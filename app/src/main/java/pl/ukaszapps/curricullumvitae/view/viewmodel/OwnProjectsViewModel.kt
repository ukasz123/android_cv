package pl.ukaszapps.curricullumvitae.view.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import pl.ukaszapps.curricullumvitae.domain.data.CVDataRepository
import pl.ukaszapps.curricullumvitae.view.model.Error
import pl.ukaszapps.curricullumvitae.view.model.Loading
import pl.ukaszapps.curricullumvitae.view.model.OwnProject
import pl.ukaszapps.curricullumvitae.view.model.ResultState
import pl.ukaszapps.curricullumvitae.view.model.Value

class OwnProjectsViewModel(private val repository: CVDataRepository) : ViewModel() {
    val ownProjects: LiveData<ResultState<List<OwnProject>>> = liveData {
        emit(Loading())
        try {
            val data = repository.getOwnProjects()
            emit(
                Value(
                    data.projects.map {
                        OwnProject(
                            name = it.title,
                            description = it.description,
                            skillsUsed = it.skills.map { skillName -> skillName.toSkillResource() },
                            url = it.repositoryUrl
                        )
                    }
                )
            )
        } catch (e: Exception) {
            emit(Error(errorMessage = "Unable to receive data"))
        }
    }
}