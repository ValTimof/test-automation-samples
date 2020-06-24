package com.github.timofeevvr.gradle.plugin


import org.gradle.api.Plugin
import org.gradle.api.Project

class SamplePlugin implements Plugin<Project> {

    @Override
    void apply(Project project) {
        def mainGradle = getClass().getClassLoader().getResource("main.gradle").toURI()
        project.apply([from: mainGradle])
    }
}
