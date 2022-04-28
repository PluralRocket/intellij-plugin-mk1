package com.github.pluralrocket.intellijpluginmk1.actions

import com.intellij.dvcs.DvcsUtil.getSelectedFile
import com.intellij.ide.util.TreeFileChooser
import com.intellij.ide.util.TreeFileChooserFactory
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.fileChooser.FileChooser
import com.intellij.openapi.fileChooser.FileChooserDescriptorFactory
import com.intellij.openapi.vcs.changes.ignore.actions.getSelectedFiles
import com.intellij.openapi.vfs.LocalFileSystem
import com.intellij.psi.PsiManager
import com.intellij.psi.util.PsiTreeUtil
import java.io.File

class BrowseNote : AnAction() {

    override fun actionPerformed(e: AnActionEvent) {

        val filesPath = "C:\\Users\\Uros\\LearningNotes\\"

        val files = File(filesPath)

        val virtualFile = LocalFileSystem.getInstance().findFileByIoFile(files)
        println(virtualFile.toString())

        val descriptor = FileChooserDescriptorFactory.createMultipleFilesNoJarsDescriptor()
//        descriptor.setRoots(virtualFile)

//        FileChooser.chooseFile(descriptor, e.project, virtualFile)

//        TODO: Research PsiFile and find out how to use TreeFileChooser

        e.project?.let {
            if (virtualFile != null) {
                val psiFile = PsiManager.getInstance(it).findFile(virtualFile) // <- returns null
                println(psiFile.toString())

                if (psiFile != null) {
                    TreeFileChooserFactory.getInstance(it)
                        .createFileChooser("Browse Notes", psiFile, psiFile.fileType, TreeFileChooser.PsiFileFilter { p -> p.isDirectory })
                        .showDialog()
                }
            }
        }
    }
}
