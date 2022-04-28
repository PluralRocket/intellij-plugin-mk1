package com.github.pluralrocket.intellijpluginmk1.listeners

import com.github.pluralrocket.intellijpluginmk1.actions.NewNote
import com.github.pluralrocket.intellijpluginmk1.services.MyApplicationService
import com.intellij.openapi.components.service
import com.intellij.openapi.project.Project
import com.intellij.openapi.project.ProjectManagerListener
import com.github.pluralrocket.intellijpluginmk1.services.MyProjectService
import com.intellij.openapi.actionSystem.ActionManager

internal class MyProjectManagerListener : ProjectManagerListener {

    val actionManager = ActionManager.getInstance()
    val newNote = NewNote()

    override fun projectOpened(project: Project) {
        project.service<MyProjectService>()
        actionManager.registerAction("NewNote", newNote)
    }

}
