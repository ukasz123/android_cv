package pl.ukaszapps.curricullumvitae.domain.data

import pl.ukaszapps.curricullumvitae.domain.model.ContactInfo
import pl.ukaszapps.curricullumvitae.domain.model.OwnProjects
import pl.ukaszapps.curricullumvitae.domain.model.Projects
import pl.ukaszapps.curricullumvitae.domain.model.Skills
import pl.ukaszapps.curricullumvitae.domain.service.Service

class CVDataRepository(private val service: Service) {

    suspend fun getSkills(): Skills = service.getSkills()
    suspend fun getProjects(): Projects = service.getProjects()
    suspend fun getOwnProjects(): OwnProjects = service.getOwnProjects()
    suspend fun getContactInfo(): ContactInfo = service.getContactInfo()
}