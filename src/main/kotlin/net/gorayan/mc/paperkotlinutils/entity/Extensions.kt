package net.gorayan.mc.paperkotlinutils.entity

import org.bukkit.Location
import org.bukkit.attribute.Attribute
import org.bukkit.entity.Entity
import org.bukkit.entity.LivingEntity

fun <T: Entity> Location.spawn(type: Class<T>, action: (T) -> Unit = {}): T {

    return world.spawn(this, type, action)

}

val LivingEntity.maxHealthPoint: Double get() = getAttribute(Attribute.GENERIC_MAX_HEALTH)!!.value