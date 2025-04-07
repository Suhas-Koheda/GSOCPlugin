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
        create<MavenPublication>("pluginMaven") {
            groupId = "dev.haas"
            artifactId = "kotlinplugin"
            version = "1.0.0"
        }
    }
    repositories {
        mavenLocal()
    }
}