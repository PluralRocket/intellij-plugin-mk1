package com.github.pluralrocket.intellijpluginmk1.actions

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.editor.Document
import com.intellij.openapi.editor.EditorFactory
import com.intellij.openapi.fileEditor.FileDocumentManager
import com.intellij.openapi.fileEditor.FileEditorManager
import com.intellij.openapi.fileEditor.FileEditorProvider
import com.intellij.openapi.vfs.LocalFileSystem
import com.intellij.openapi.wm.impl.IdeRootPane
import com.intellij.psi.impl.PsiDocumentManagerImpl
import com.intellij.ui.EditorTextField
import java.io.File

class OpenNote : AnAction(){

    override fun actionPerformed(e: AnActionEvent) {

        val filePath = "C:\\Users\\Uros\\LearningNotes\\OCP\\JavaEnvironment.md"

        val file = File(filePath)

        val project = e.project

        val virtualFile = LocalFileSystem.getInstance().findFileByIoFile(file)

        val document = virtualFile?.let { FileDocumentManager.getInstance().getDocument(it) }

        val fileEditorManager = project?.let { FileEditorManager.getInstance(it) }

        if (virtualFile != null) {
            if (fileEditorManager != null) {
                fileEditorManager.openFile(virtualFile, true)
            }
        }
    }

}