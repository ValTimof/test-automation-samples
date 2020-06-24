package com.github.timofeevvr.gradle.plugin.tasks

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.TaskAction

class SayHelloTask extends DefaultTask {

    @Input
    String name = "name"

    @TaskAction
    def say() {
        logger.quiet("Hello, $name")
    }
}
