package net.gorayan.mc.paperkotlinutils.text

import net.kyori.adventure.text.Component

fun planeText(content: String) = textComponent(content).resetStyle()

fun emptyText() = Component.empty()

fun textComponent(content: String) = Component.text(content)