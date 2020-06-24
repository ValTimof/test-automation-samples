package com.github.timofeevvr.gradle.plugin

import org.gradle.internal.impldep.com.google.common.io.Files
import org.gradle.testkit.runner.BuildResult
import org.gradle.testkit.runner.GradleRunner
import spock.lang.Specification

import static org.gradle.testkit.runner.TaskOutcome.SUCCESS

class PluginIntegrationTest extends Specification {

    static final File projectDir = Files.createTempDir()
    static final File settingsGradle = new File(projectDir, "settings.gradle")
    static final File buildGradle = new File(projectDir, "build.gradle")

    def setupSpec() {
        settingsGradle.write "rootProject.name = 'testProject'"
        buildGradle.write """plugins {
                            |   id "com.github.timofeevvr.gradle.plugin.sample"
                            |}
                            """.stripMargin()
    }

    def "build test"() {
        given:
        def gradleRunner = GradleRunner.create()
                .withProjectDir(projectDir)
                .withPluginClasspath()
                .withArguments("clean", "build", '-i')
        when:
        BuildResult buildResult = gradleRunner.build()
        then:
        buildResult.task(':build').outcome == SUCCESS
    }
}
