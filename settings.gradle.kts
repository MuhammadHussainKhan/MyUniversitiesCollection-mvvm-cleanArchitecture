pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "MyUniversityCollection3"
include(":app")
include(":uni:uni_data")
include(":uni:uni_domain")
include(":uni:uni_presentation")
include(":detail:detail_data")
include(":detail:detail_domain")
include(":detail:detail_presentation")
include(":common:common_utils")
include(":common:common_db")
