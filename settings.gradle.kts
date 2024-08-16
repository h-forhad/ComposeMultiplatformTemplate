pluginManagement {
    repositories {
        google {
            mavenContent {
                includeGroupByRegex(".*google.*")
                includeGroupByRegex(".*android.*")
                includeGroupByRegex(".*androidx.*")
            }
        }

        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositories {
        google {
            mavenContent {
                includeGroupByRegex(".*google.*")
                includeGroupByRegex(".*android.*")
                includeGroupByRegex(".*androidx.*")
            }
        }

        mavenCentral()
    }
}

include(":app")
include(":decompose-router")
include(":app:desktop")