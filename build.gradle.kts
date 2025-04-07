plugins {
    kotlin("jvm") version "1.9.24" // Use stable version
    `kotlin-dsl`
    `maven-publish`
    `java-gradle-plugin` // Add this for better plugin support
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
    testImplementation(kotlin("test"))
}

kotlin {
    jvmToolchain(17)
}



publishing {
    publications {
        create<MavenPublication>("maven") {
            from(components["java"])
        }
    }
    repositories {
        mavenLocal()
    }
}