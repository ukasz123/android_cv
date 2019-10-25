package pl.ukaszapps.curricullumvitae.view.model

data class Project (val name: String, val from: String, val to: String? = null, val company: String, val skills: List<Int>)