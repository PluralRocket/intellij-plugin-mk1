package com.github.pluralrocket.intellijpluginmk1.dialog

import com.intellij.openapi.ui.DialogWrapper
import com.intellij.ui.EditorTextField
import com.intellij.util.ui.JBUI
import com.intellij.util.ui.components.BorderLayoutPanel
import java.awt.BorderLayout
import javax.swing.JComponent
import javax.swing.JPanel

class NoteDialogWrapper : DialogWrapper(true) {

    init {
        title = "Note Dialog"
        init()
    }

    override fun createCenterPanel(): JComponent? {
        val dialogPanel = JPanel(BorderLayout())
        val editor = EditorTextField("")
        dialogPanel.add(editor, BorderLayout.CENTER)
        return dialogPanel
    }
}