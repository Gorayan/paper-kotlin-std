package net.gorayan.mc.paperkotlinutils.text

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor
import net.kyori.adventure.text.format.TextDecoration

fun Component.black(): Component = color(NamedTextColor.BLACK)
fun Component.darkBlue(): Component = color(NamedTextColor.DARK_BLUE)
fun Component.darkGreen(): Component = color(NamedTextColor.DARK_GREEN)
fun Component.darkAqua(): Component = color(NamedTextColor.DARK_AQUA)
fun Component.darkRed(): Component = color(NamedTextColor.DARK_RED)
fun Component.darkPurple(): Component = color(NamedTextColor.DARK_PURPLE)
fun Component.gold(): Component = color(NamedTextColor.GOLD)
fun Component.gray(): Component = color(NamedTextColor.GRAY)
fun Component.darkGray(): Component = color(NamedTextColor.DARK_GRAY)
fun Component.blue(): Component = color(NamedTextColor.BLUE)
fun Component.green(): Component = color(NamedTextColor.GREEN)
fun Component.aqua(): Component = color(NamedTextColor.AQUA)
fun Component.red(): Component = color(NamedTextColor.RED)
fun Component.lightPurple(): Component = color(NamedTextColor.LIGHT_PURPLE)
fun Component.yellow(): Component = color(NamedTextColor.YELLOW)
fun Component.white(): Component = color(NamedTextColor.WHITE)

fun Component.newLine(): Component = append(Component.newline())

fun Component.bold(): Component = decorate(TextDecoration.BOLD)
fun Component.italic(): Component = decorate(TextDecoration.ITALIC)
fun Component.underline(): Component = decorate(TextDecoration.UNDERLINED)
fun Component.strikethrough(): Component = decorate(TextDecoration.STRIKETHROUGH)
fun Component.obfuscated(): Component = decorate(TextDecoration.OBFUSCATED)

fun Component.removeBold(): Component = decoration(TextDecoration.BOLD, TextDecoration.State.FALSE)
fun Component.removeItalic(): Component = decoration(TextDecoration.ITALIC, TextDecoration.State.FALSE)
fun Component.removeUnderline(): Component = decoration(TextDecoration.UNDERLINED, TextDecoration.State.FALSE)
fun Component.removeStrikethrough(): Component = decoration(TextDecoration.STRIKETHROUGH, TextDecoration.State.FALSE)
fun Component.removeObfuscated(): Component = decoration(TextDecoration.OBFUSCATED, TextDecoration.State.FALSE)

fun Component.resetStyle(): Component {
    return white()
        .removeBold()
        .removeItalic()
        .removeUnderline()
        .removeStrikethrough()
        .removeObfuscated()
}