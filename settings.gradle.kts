import java.net.URL

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
        maven { url = uri("https://jitpack.io" ) }
        maven { url = uri("https://maven.google.com" ) }
        jcenter()

    }
}

rootProject.name = "MGR_E_LIBRARY"
include(":app")
