plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.graalvm.polyglot:js:23.1.1")
    implementation("org.graalvm.polyglot:polyglot:23.1.1")
    implementation("org.graalvm.polyglot:python:23.1.1")
    implementation("org.graalvm.polyglot:ruby:23.1.1")
    implementation("org.graalvm.polyglot:tools:23.1.1")
    implementation("org.graalvm.polyglot:wasm:23.1.1")

    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}