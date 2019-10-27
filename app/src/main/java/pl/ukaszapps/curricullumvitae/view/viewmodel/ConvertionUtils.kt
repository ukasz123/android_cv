package pl.ukaszapps.curricullumvitae.view.viewmodel

import androidx.annotation.DrawableRes
import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import pl.ukaszapps.curricullumvitae.R
import pl.ukaszapps.curricullumvitae.view.model.Error
import pl.ukaszapps.curricullumvitae.view.model.Loading
import pl.ukaszapps.curricullumvitae.view.model.ResultState
import pl.ukaszapps.curricullumvitae.view.model.Value

internal const val SKILL_PLACEHOLDER = R.drawable.ic_extension;

@DrawableRes
internal fun String?.toSkillResource(): Int {
    return this?.let {
        when(it.toLowerCase()){
            "android" -> R.drawable.ic_android
            "ios" -> R.drawable.ic_ios
            "flutter" -> R.drawable.ic_flutter
            "dart" -> R.drawable.ic_dart
            "java" -> R.drawable.ic_java
            "kotlin" -> R.drawable.ic_kotlin
            "rxjava" -> R.drawable.ic_rxjava
            "gradle" -> R.drawable.ic_gradle
            "git" -> R.drawable.ic_git
            "html", "html5" -> R.drawable.ic_html5
            "css", "css3" -> R.drawable.ic_css3
            else -> null
        }
    } ?: SKILL_PLACEHOLDER
}



inline fun <T,R> LiveData<ResultState<T>>.mapValue(crossinline transform: (T)->R) = this.map {
    when(it){
        is Loading -> Loading<R>()
        is Error -> Error<R>(errorMessage = it.errorMessage)
        is Value -> Value(transform(it.value))
    }
}