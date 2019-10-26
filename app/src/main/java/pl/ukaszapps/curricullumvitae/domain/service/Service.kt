package pl.ukaszapps.curricullumvitae.domain.service

import pl.ukaszapps.curricullumvitae.domain.model.OwnProjects
import pl.ukaszapps.curricullumvitae.domain.model.Projects
import pl.ukaszapps.curricullumvitae.domain.model.Skills

interface Service {
    suspend fun getSkills(): Skills
    suspend fun getProjects(): Projects
    suspend fun getOwnProjects(): OwnProjects
}