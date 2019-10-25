package pl.ukaszapps.curricullumvitae.view.model

data class OwnProject(val name: String, val description: String, val skillsUsed: List<Int> = emptyList(), val url: String? = null)