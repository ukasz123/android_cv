package pl.ukaszapps.curricullumvitae.domain.model

data class Skill(
    val name: String,
    val primary: Boolean = false,
    val icon: String? = null,
    val level: Int
)

data class Skills(val skills: List<Skill> = emptyList())