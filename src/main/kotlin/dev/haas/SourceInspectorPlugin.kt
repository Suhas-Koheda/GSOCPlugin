package dev.haas

import org.gradle.api.*
import org.gradle.api.tasks.*
import org.jetbrains.kotlin.gradle.dsl.KotlinProjectExtension

class SourceInspectionTask : DefaultTask() {
    @TaskAction
    fun inspectSources() {
        val kotlinExtension = project.extensions.findByType(KotlinProjectExtension::class.java)
            ?: throw GradleException("Kotlin Plugin Not Found")

        kotlinExtension.sourceSets.forEach { sourceSet ->
            logger.lifecycle("SourceSet: ${sourceSet.name}")
            sourceSet.kotlin.srcDirs.forEach { srcDir ->
                logger.lifecycle("Source directory: $srcDir")
            }
        }
    }
}

class SourceInspectionPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        project.tasks.register("inspectSources", SourceInspectionTask::class.java)
    }
}