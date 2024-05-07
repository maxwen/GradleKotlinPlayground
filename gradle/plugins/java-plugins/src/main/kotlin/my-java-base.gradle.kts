import com.example.gradle.Slf4JSimpleRule
import gradle.kotlin.dsl.accessors._a36adeff7943c18d5e9e07d718caef3f.compileJava
import gradle.kotlin.dsl.accessors._a36adeff7943c18d5e9e07d718caef3f.compileTestJava
import gradle.kotlin.dsl.accessors._a36adeff7943c18d5e9e07d718caef3f.javadoc
import gradle.kotlin.dsl.accessors._a36adeff7943c18d5e9e07d718caef3f.sourceSets
import gradle.kotlin.dsl.accessors._f8ba0958e671444bc04a21941c7f7ed6.build
import org.gradle.kotlin.dsl.provider.inLenientMode

plugins {
    id("java")
    id("com.diffplug.spotless")
}

//sourceSets.main {
////    java.setSrcDirs(listOf(layout.projectDirectory.dir("sources")))
//}
//sourceSets.test {
//
//}

sourceSets.create("integrationTest")

tasks.register<Test>("integrationTest") {
    group = "My Group"
    description = "integration test"

    testClassesDirs = sourceSets["integrationTest"].output.classesDirs
    classpath = sourceSets["integrationTest"].runtimeClasspath

    useJUnitPlatform()
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(17))
}

tasks.withType<JavaCompile>().configureEach {
    options.encoding = "UTF-8"
}

tasks.named<JavaCompile>("compileJava") {} // == tasks.compileJava

tasks.compileTestJava {
}

tasks.test {
    useJUnitPlatform {
        excludeTags("slow")
    }
    maxParallelForks = 4
    maxHeapSize = "1g"
}

tasks.register<Test>("testSlow") {
    group = "My Group"
    description = "test slow"

    testClassesDirs = sourceSets.test.get().output.classesDirs
    classpath = sourceSets.test.get().runtimeClasspath

    useJUnitPlatform {
        includeTags("slow")
    }
}

tasks.check {
    dependsOn(tasks.named("testSlow"))
}

tasks.javadoc {

}

//dependencies.components {
//    withModule<Slf4JSimpleRule>("org.slf4j:slf4j-simple")
//}