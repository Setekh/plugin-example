package com.example

import com.archid.ext.ArchidEx
import com.archid.ext.EventKeys
import org.l2jmobius.gameserver.enums.ChatType
import org.l2jmobius.gameserver.model.actor.instance.PlayerInstance
import org.l2jmobius.gameserver.network.serverpackets.CreatureSay

class ExampleEventListener: ArchidEx.Listener {
    override fun onEvent(key: Int, defaultValue: Any?, params: Array<out Any>): Any {
        when (key) {
            EventKeys.EnterWorld -> {
                val player = params[0] as PlayerInstance
                player.sendPacket(CreatureSay(null, ChatType.PARTYROOM_COMMANDER, "System", "Welcome back big boy!"))
            }
        }
        return super.onEvent(key, defaultValue, params)
    }
}