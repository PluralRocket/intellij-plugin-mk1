package com.github.pluralrocket.intellijpluginmk1.actions

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import java.io.File
import java.nio.file.Paths

class NewNote : AnAction() {

    override fun actionPerformed(e: AnActionEvent) {
        val project = e.project

        val notesFolder = File("C:\\Users\\Uros\\LearningNotes")
        val treeWalk = notesFolder.walkTopDown()

        println(treeWalk.toSortedSet())

        val fileName = project?.basePath + "\\zettel_test.md"
        val cwd = Paths.get("").toAbsolutePath().toString()
        println(cwd)
        var file = File(fileName)
        println(file.absolutePath)

        val isCreated = file.createNewFile()

        println(isCreated)
    }

}