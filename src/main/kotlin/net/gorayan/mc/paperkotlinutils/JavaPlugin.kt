package net.gorayan.mc.paperkotlinutils

import org.bukkit.plugin.java.JavaPlugin

fun Any.getProvidingPlugin(): JavaPlugin {

    return JavaPlugin.getProvidingPlugin(this::class.java)

}