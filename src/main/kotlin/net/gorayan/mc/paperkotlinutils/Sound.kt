package net.gorayan.mc.paperkotlinutils

import org.bukkit.Location
import org.bukkit.Sound
import org.bukkit.SoundCategory
import org.bukkit.entity.Player

fun Location.playSound(
    sound: Sound,
    category: SoundCategory = SoundCategory.NEUTRAL,
    volume: Float = 1.0f,
    pitch: Float = 1.0f,
) = this.world.playSound(this, sound, category, volume, pitch)

fun Player.playSound(
    sound: Sound,
    category: SoundCategory = SoundCategory.NEUTRAL,
    volume: Float = 1.0f,
    pitch: Float = 1.0f,
    location: Location = this.location,
) = this.playSound(location, sound, category, volume, pitch)
