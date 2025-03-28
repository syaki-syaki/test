pluginManagement {
    repositories {
        gradlePluginPortal() // ✅ plugins {} に必要！
        google()
        mavenCentral()
        maven { url = uri("https://maven.pkg.jetbrains.space/public/p/apollo/maven") }
    }
}


dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "sasakitest"
include(":app")