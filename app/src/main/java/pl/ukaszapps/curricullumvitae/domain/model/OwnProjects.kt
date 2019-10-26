package pl.ukaszapps.curricullumvitae.domain.model

data class OwnProject(
    val title: String,
    val description: String,
    val repositoryUrl: String,
    val imageUrl: String? = null,
    val skills: List<String> = emptyList()

)

data class OwnProjects(val projects: List<OwnProject>)