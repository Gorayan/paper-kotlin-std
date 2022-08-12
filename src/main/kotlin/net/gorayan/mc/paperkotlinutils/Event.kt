package net.gorayan.mc.paperkotlinutils

import org.bukkit.event.Cancellable
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.plugin.java.JavaPlugin

fun Cancellable.cancel() {
    this.isCancelled = true
}

fun JavaPlugin.register(listener: Listener) {

    server.pluginManager.registerEvents(listener, this)

}

inline fun <reified T> JavaPlugin.register(crossinline eventHandler: (T) -> Unit) {

    val listener = object : Listener {

        @EventHandler
        private fun onEvent(event: T) = eventHandler(event)

    }

    register(listener)

}