package net.gorayan.mc.paperkotlinutils.text

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.serializer.gson.GsonComponentSerializer

fun Component.json(): String = GsonComponentSerializer.gson().serialize(this)