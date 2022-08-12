package net.gorayan.mc.paperkotlinutils.item

import net.kyori.adventure.text.Component
import org.bukkit.Color
import org.bukkit.OfflinePlayer
import org.bukkit.inventory.ItemFlag
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.Damageable
import org.bukkit.inventory.meta.LeatherArmorMeta
import org.bukkit.inventory.meta.PotionMeta
import org.bukkit.inventory.meta.SkullMeta

fun ItemStack.addItemFlagAll(): ItemStack {

    ItemFlag.values().forEach {
        addItemFlags(it)
    }

    return this

}

fun ItemStack.isAir() = type.isAir

fun ItemStack.setOwner(player: OfflinePlayer): ItemStack {

    editMeta {
        if (it !is SkullMeta) return@editMeta
        it.owningPlayer = player
    }

    return this

}

fun ItemStack.rename(component: Component): ItemStack {

    editMeta {
        it.displayName(component)
    }

    return this

}

fun ItemStack.setLore(vararg components: Component): ItemStack {

    editMeta {
        it.lore(components.toList())
    }

    return this

}

fun ItemStack.setLore(components: List<Component>): ItemStack {

    editMeta {
        it.lore(components)
    }

    return this

}

fun ItemStack.setCount(count: Int): ItemStack {

    amount = count

    return this

}

fun ItemStack.setColor(color: Color): ItemStack {

    editMeta {

        if (it is LeatherArmorMeta) {
            it.setColor(color)
        }

        if (it is PotionMeta) {
            it.color = color
        }

    }

    return this

}

fun ItemStack.setUnbreakable(value: Boolean): ItemStack {

    editMeta {

        it.isUnbreakable = value

    }

    return this

}

fun ItemStack.setDurability(value: Int): ItemStack {

    editMeta {
        if (it !is Damageable) return@editMeta
        it.damage = value
    }

    return this

}

fun ItemStack.durabilityOrNull() = when (val itemMeta = this.itemMeta) {

    is Damageable -> itemMeta.damage

    else -> null

}


val ItemStack.maxDurability: Short
    get() = this.type.maxDurability