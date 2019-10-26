package pl.ukaszapps.curricullumvitae.view.viewmodel

import androidx.annotation.DrawableRes
import pl.ukaszapps.curricullumvitae.R

@DrawableRes
internal fun String?.toSkillResource(): Int {
    return this?.let {
        when(it){
            "android" -> R.drawable.ic_location_city
            else -> null
        }
    } ?: R.drawable.ic_error_outline
}