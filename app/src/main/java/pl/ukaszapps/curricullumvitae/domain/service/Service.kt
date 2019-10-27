package pl.ukaszapps.curricullumvitae.domain.service

import pl.ukaszapps.curricullumvitae.domain.model.ContactInfo
import pl.ukaszapps.curricullumvitae.domain.model.OwnProjects
import pl.ukaszapps.curricullumvitae.domain.model.Projects
import pl.ukaszapps.curricullumvitae.domain.model.Skills
import retrofit2.http.GET

interface Service {

    @GET("skills/skills_data.json")
    suspend fun getSkills(): Skills

    @GET("history/projects.json")
    suspend fun getProjects(): Projects

    @GET("other_projects/en.json")
    suspend fun getOwnProjects(): OwnProjects

    @GET("contactdata/en.json")
    suspend fun getContactInfo(): ContactInfo
}