plugins {
    kotlin("jvm") version "1.9.24"
    `java-gradle-plugin`
    `maven-publish`
}

group = "dev.haas"
version = "1.0.0"

repositories {
    mavenCentral()
    gradlePluginPortal()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.9.24")
}

kotlin {
    jvmToolchain(17)
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = "dev.haas"
            artifactId = "kotlingradleplugin"
            version = "2.0"

            from(components["java"])
        }
    }
}