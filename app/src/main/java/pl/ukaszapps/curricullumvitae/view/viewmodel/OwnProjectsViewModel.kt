package pl.ukaszapps.curricullumvitae.view.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import pl.ukaszapps.curricullumvitae.R
import pl.ukaszapps.curricullumvitae.view.model.Loading
import pl.ukaszapps.curricullumvitae.view.model.OwnProject
import pl.ukaszapps.curricullumvitae.view.model.ResultState
import pl.ukaszapps.curricullumvitae.view.model.Value

class OwnProjectsViewModel : ViewModel() {
    val ownProjects: LiveData<ResultState<List<OwnProject>>> = liveData {
        emit(Loading())
        emit(
            Value(
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
        )
    }
}