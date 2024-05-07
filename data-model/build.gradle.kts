plugins {
    id("my-java-library")
}
dependencies {
    implementation(platform("com.example:platform"))

    implementation("org.apache.commons:commons-lang3")
}