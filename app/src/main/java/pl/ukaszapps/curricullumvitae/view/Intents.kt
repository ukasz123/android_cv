package pl.ukaszapps.curricullumvitae.view

import android.content.Context

fun Context.showUrl(url: String?) {
    url?.let {
        val webpage = android.net.Uri.parse(it)
        val intent = android.content.Intent(android.content.Intent.ACTION_VIEW, webpage)
        if (intent.resolveActivity(this.packageManager) != null) {
            this.startActivity(intent)
        }

    }
}