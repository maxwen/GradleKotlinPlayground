pluginManagement {
    repositories.gradlePluginPortal()
    //repositories.mavenCentral()
    //repositories.google()

    includeBuild("gradle/plugins")

}

dependencyResolutionManagement {
    repositories.mavenCentral()
//    repositories.google()
//    repositories.mavenLocal()
//    repositories.maven("https://foo.com/repo") {
//        credentials.username="xxx"
//        credentials.password="yyy"
//    }
//    includeBuild("../other-project")
}

rootProject.name="GradleKotlinPlayground"

include("app")
include("business-logic")
include("data-model")