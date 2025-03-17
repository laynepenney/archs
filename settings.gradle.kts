/*
 * Copyright (c) Layne Penney 2025.
 */

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
rootProject.name = "Archs"

include(":app")
include(":core-data")
include(":core-database")
include(":core-testing")
include(":core-ui")
include(":feature-pattern")
include(":test-app")
