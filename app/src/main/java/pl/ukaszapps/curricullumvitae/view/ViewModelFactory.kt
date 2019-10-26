package pl.ukaszapps.curricullumvitae.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import pl.ukaszapps.curricullumvitae.domain.data.CVDataRepository


class ViewModelFactory(private val repository: CVDataRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        //noinspection TryWithIdenticalCatches
        try {
            return modelClass.getConstructor(CVDataRepository::class.java).newInstance(repository)
        } catch (e: InstantiationException) {
            throw RuntimeException("Cannot create an instance of $modelClass", e)
        } catch (e: IllegalAccessException) {
            throw RuntimeException("Cannot create an instance of $modelClass", e)
        }

    }
}