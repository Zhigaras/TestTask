pluginManagement {
    repositories {
        google()
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

rootProject.name = "TestTask"
include(":app")
include(":core")
include(":uiKit")
include(":feature:hotel")
include(":cloudService")
include(":feature:rooms")
include(":adapterDelegate")
include(":feature:booking")
include(":feature:ordered")
