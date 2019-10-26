package pl.ukaszapps.curricullumvitae.view.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import kotlinx.coroutines.delay
import pl.ukaszapps.curricullumvitae.R
import pl.ukaszapps.curricullumvitae.view.model.Loading
import pl.ukaszapps.curricullumvitae.view.model.ResultState
import pl.ukaszapps.curricullumvitae.view.model.Skill
import pl.ukaszapps.curricullumvitae.view.model.Value

class SkillsViewModel : ViewModel() {

    val skills: LiveData<ResultState<List<Skill>>> = liveData {
        emit(Loading<List<Skill>>() as ResultState<List<Skill>>)
        delay(6000)
        emit(
            Value(
            listOf(
                Skill(name = "flutter", icon = R.drawable.ic_location_city, level = 4),
                Skill(name = "android", icon = R.drawable.ic_error_outline, level = 3),
                Skill(name = "dart", icon = R.drawable.ic_location_city, level = 4),
                Skill(name = "git", icon = R.drawable.ic_location_city, level = 1),
                Skill(name = "java", icon = R.drawable.ic_error_outline, level = 10)
            )
        )
        )
    }
}