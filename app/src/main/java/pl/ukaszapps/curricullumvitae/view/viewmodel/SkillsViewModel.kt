package pl.ukaszapps.curricullumvitae.view.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import kotlinx.coroutines.delay
import pl.ukaszapps.curricullumvitae.domain.data.CVDataRepository
import pl.ukaszapps.curricullumvitae.view.model.Error
import pl.ukaszapps.curricullumvitae.view.model.Loading
import pl.ukaszapps.curricullumvitae.view.model.ResultState
import pl.ukaszapps.curricullumvitae.view.model.Skill
import pl.ukaszapps.curricullumvitae.view.model.Value

class SkillsViewModel(private val repository: CVDataRepository) : ViewModel() {

    val skills: LiveData<ResultState<List<Skill>>> = liveData {
        emit(Loading<List<Skill>>() as ResultState<List<Skill>>)
        try {
            val data = repository.getSkills()
            emit(Value(
                data.skills.map {
                    Skill(
                        name = it.name,
                        icon = it.icon.toSkillResource(),
                        level = it.level
                    )
                }
            ))
        } catch (e: Exception) {
            emit(Error(errorMessage = "Unable to receive data"))
        }
    }
}
