import com.example.gradle.Slf4JSimpleRule
import gradle.kotlin.dsl.accessors._a36adeff7943c18d5e9e07d718caef3f.compileJava
import gradle.kotlin.dsl.accessors._a36adeff7943c18d5e9e07d718caef3f.compileTestJava
import gradle.kotlin.dsl.accessors._a36adeff7943c18d5e9e07d718caef3f.javadoc

plugins {
    id("java")
    id("com.diffplug.spotless")
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

}

tasks.javadoc {

}

//dependencies.components {
//    withModule<Slf4JSimpleRule>("org.slf4j:slf4j-simple")
//}