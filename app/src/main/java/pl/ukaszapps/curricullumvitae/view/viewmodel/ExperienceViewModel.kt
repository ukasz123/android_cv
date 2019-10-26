package pl.ukaszapps.curricullumvitae.view.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import kotlinx.coroutines.delay
import pl.ukaszapps.curricullumvitae.R
import pl.ukaszapps.curricullumvitae.view.model.Loading
import pl.ukaszapps.curricullumvitae.view.model.Project
import pl.ukaszapps.curricullumvitae.view.model.ResultState
import pl.ukaszapps.curricullumvitae.view.model.Value

class ExperienceViewModel:ViewModel() {
    val experience: LiveData<ResultState<List<Project>>> = liveData {
        emit(Loading())
        delay(2_000)
        emit(
            Value(
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
        )
    }
}