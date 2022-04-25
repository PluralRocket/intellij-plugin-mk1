package com.github.pluralrocket.intellijpluginmk1.services

import com.intellij.openapi.project.Project
import com.github.pluralrocket.intellijpluginmk1.MyBundle

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
