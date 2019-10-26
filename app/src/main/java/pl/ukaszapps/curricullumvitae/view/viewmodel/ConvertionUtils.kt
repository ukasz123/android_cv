package pl.ukaszapps.curricullumvitae.view.viewmodel

import androidx.annotation.DrawableRes
import pl.ukaszapps.curricullumvitae.R

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
    } ?: R.drawable.ic_extension
}