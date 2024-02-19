pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "android-basic"
include(":app")
include(":app:activity")
include(":app:fragment")
include(":app:service")
include(":app:braodcast")
include(":app:popups")
include(":app:notifications")
