plugins {
    kotlin("jvm") version "1.9.24"
    `kotlin-dsl`
    `maven-publish`
    `java-gradle-plugin`
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

gradlePlugin {
    plugins {
        create("kotlinPlugin") {
            id = "dev.haas.kotlinplugin"
            implementationClass = "dev.haas.SourceInspectionPlugin"
        }
    }
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            from(components["java"])
            // Add these to ensure proper plugin marker publication
            groupId = "dev.haas"
            artifactId = "kotlinplugin"
            version = "1.0.0"
        }
    }
    repositories {
        mavenLocal()
    }
}