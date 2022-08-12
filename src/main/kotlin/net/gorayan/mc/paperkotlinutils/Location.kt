package net.gorayan.mc.paperkotlinutils

import org.bukkit.Location
import org.bukkit.entity.Entity

fun Entity.distance(location: Location) = this.location.distance(location)

fun Entity.distanceOrNull(location: Location) = this.location.distanceOrNull(location)

fun Entity.distance(entity: Entity) = this.distance(entity.location)

fun Entity.distanceOrNull(entity: Entity) = this.distanceOrNull(entity.location)

fun Location.distanceOrNull(location: Location): Double? = if (location.world != this.world) null else this.distanceOrNull(location)

