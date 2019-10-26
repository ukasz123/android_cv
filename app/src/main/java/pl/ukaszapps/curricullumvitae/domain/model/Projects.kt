package pl.ukaszapps.curricullumvitae.domain.model

data class Project(
    val code: String,
    val name: String,
    val from: String,
    val to: String? = null,
    val skillsUsed: List<String> = emptyList(),
    val company: String
)

data class Projects(
    val projects: List<Project>
)