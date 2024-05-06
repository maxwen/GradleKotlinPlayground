import com.example.gradle.JarCount

plugins {
    id("application")
    id("my-java-base")
}

tasks.register<JarCount>("countJars") {
    group = "My Group"
    description = "count"

    allJars.from(tasks.jar)
    allJars.from(configurations.runtimeClasspath)

    countFile.set(layout.buildDirectory.file("gen/count.txt"))

}

tasks.register<Zip>("bundle") {
    group = "My Group"
    description = "package all"

    from(tasks.jar)
    from(configurations.runtimeClasspath)
    from(tasks.named("countJars"))


    destinationDirectory.set(layout.buildDirectory.dir("distribution"))
}

tasks.build {
    dependsOn(tasks.named("bundle"))
}

tasks.register("buildAll") {
    group = "My Group"
    description = "build more"

    dependsOn(tasks.build)
    dependsOn(tasks.named("countJars"))
}
