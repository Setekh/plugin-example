package com.example

import com.archid.ext.ArchidEx
import com.archid.plugins.Plugin
import com.archid.plugins.models.Manifest

class ExamplePlugin: Plugin {
    private val exampleListener = ExampleEventListener()

    override fun load(manifest: Manifest) {
        ArchidEx.register(exampleListener)
    }

    override fun unload(manifest: Manifest) {
        ArchidEx.unregister(exampleListener)
    }
}