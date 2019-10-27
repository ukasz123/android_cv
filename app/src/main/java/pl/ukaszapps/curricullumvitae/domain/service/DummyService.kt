package pl.ukaszapps.curricullumvitae.domain.service

import pl.ukaszapps.curricullumvitae.domain.model.*

object DummyService : Service {
    override suspend fun getSkills(): Skills {
        return Skills(
            listOf(
                Skill(name = "flutter", icon = "flutter", level = 4),
                Skill(name = "android", icon = "android", level = 3),
                Skill(name = "dart", level = 4),
                Skill(name = "git", level = 1),
                Skill(name = "java", level = 10)
            )
        )
    }

    override suspend fun getProjects(): Projects {
        return Projects(
            listOf(
                Project(code= "abc", name="ABC project", skillsUsed = listOf("android", "git"),company = "ABC", from = "2019-01"),
                Project(code= "cde", name="CDE project", skillsUsed = listOf("android", "git", "kotlin"),company = "CDE", from = "2018-01", to = "2018-12"),
                Project(code= "cdeFirst", name="Alpha CDE project", skillsUsed = listOf("android", "git", "java"),company = "CDE", from = "2017-01", to = "2017-12")
            )
        )
    }

    override suspend fun getOwnProjects(): OwnProjects {
        return OwnProjects(
            projects = listOf(
                OwnProject(
                    title = "Dalton Timer",
                    skills = listOf("flutter", "android", "ios"),
                    description = "Mobile application inspired by a clock helping tool for Dalton Plan written in Flutter.",
                    repositoryUrl = "https://bitbucket.org/ukasz123/dalton_timer/src/master/"
                )
            )
        )
    }

    override suspend fun getContactInfo(): ContactInfo {
        return ContactInfo(
            address = "Warsaw, Poland",
            github = "https://github.com",
            bitbucket = "https://bitbucket.org",
            linkedin = "https://www.linkedin.com"
        )
    }

}