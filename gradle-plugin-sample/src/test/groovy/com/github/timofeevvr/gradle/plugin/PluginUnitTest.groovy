package com.github.timofeevvr.gradle.plugin

import org.gradle.testfixtures.ProjectBuilder
import spock.lang.Specification

class PluginUnitTest extends Specification {

    def "sayHello task test"() {
        given:
        def project = ProjectBuilder.builder().build()
        when:
        project.pluginManager.apply('com.github.timofeevvr.gradle.plugin.sample')
        then:
        project.tasks.sayHello != null
        project.tasks.sayHello.say()
    }
}
