package pl.ukaszapps.curricullumvitae

import androidx.lifecycle.ViewModelProvider
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import pl.ukaszapps.curricullumvitae.domain.data.CVDataRepository
import pl.ukaszapps.curricullumvitae.domain.service.Service
import pl.ukaszapps.curricullumvitae.view.ViewModelFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

internal val retrofit by lazy {
    Retrofit.Builder()
        .baseUrl("https://ukasz123.github.io/data/")
        .addConverterFactory(
            MoshiConverterFactory.create(
                Moshi.Builder().add(
                    KotlinJsonAdapterFactory()
                ).build()
            )
        )
        .build()
}

internal val webService: Service by lazy { retrofit.create(Service::class.java) }

internal val repository: CVDataRepository by lazy {
    CVDataRepository(service = webService)
}
internal val viewModelFactory: ViewModelProvider.Factory by lazy {
    ViewModelFactory(repository)
}