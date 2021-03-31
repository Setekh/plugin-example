package com.example

import com.archid.ext.ArchidEx
import com.archid.plugins.Plugin
import com.archid.plugins.models.Manifest
import java.io.File
import java.io.FileInputStream
import java.util.*

class ExamplePlugin: Plugin {
    private var exampleListener: ExampleEventListener? = null

    override fun load(manifest: Manifest) {
        val props = Properties()
        props.load(FileInputStream(File(manifest.workDir, "example-settings.properties")))
        val message = props.getProperty("WelcomeSystemMessage", "404: No message")

        exampleListener = ExampleEventListener(message)
        ArchidEx.register(exampleListener)

        props.clear()
    }

    override fun unload(manifest: Manifest) {
        val exampleListener = exampleListener ?: return
        ArchidEx.unregister(exampleListener)
    }
}