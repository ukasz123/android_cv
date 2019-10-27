package pl.ukaszapps.curricullumvitae.view.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import pl.ukaszapps.curricullumvitae.domain.data.CVDataRepository
import pl.ukaszapps.curricullumvitae.domain.model.ContactInfo
import pl.ukaszapps.curricullumvitae.view.model.Error
import pl.ukaszapps.curricullumvitae.view.model.Loading
import pl.ukaszapps.curricullumvitae.view.model.ResultState
import pl.ukaszapps.curricullumvitae.view.model.Value

class ContactDataViewModel(private val repository: CVDataRepository) : ViewModel() {
    private val infoLiveData = liveData<ResultState<ContactInfo>> {
        emit(Loading())
        try {
            emit(Value(repository.getContactInfo()))
        } catch (e: Exception) {
            emit(Error(errorMessage = "Unable to retrieve data"))
        }
    }

    val address = infoLiveData.mapValue { it.address }

    val linkedInUrl = infoLiveData.mapValue { it.linkedin }

    val bitbucketUrl = infoLiveData.mapValue { it.bitbucket }

    val githubUrl = infoLiveData.mapValue { it.github }
}