package com.github.timofeevvr.gradle.plugin


import org.gradle.testkit.runner.BuildResult
import org.gradle.testkit.runner.GradleRunner
import org.junit.jupiter.api.io.TempDir
import spock.lang.Specification

import java.nio.file.Path

import static org.gradle.testkit.runner.TaskOutcome.SUCCESS

class PluginIntegrationTest extends Specification {

    def "build test"(@TempDir Path dir) {
        given:
        def gradleRunner = GradleRunner.create()
                .withPluginClasspath()
                .withArguments("clean", "build", '-i')
        when:
        BuildResult buildResult = gradleRunner.build()
        then:
        buildResult.task(':build').outcome == SUCCESS
    }
}
