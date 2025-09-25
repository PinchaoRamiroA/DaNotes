pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal() // 👈 necesario para KSP
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "DatNotes"
include(":app")
