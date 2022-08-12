package net.gorayan.mc.paperkotlinutils.item

import net.gorayan.mc.paperkotlinutils.getProvidingPlugin
import org.bukkit.NamespacedKey
import org.bukkit.inventory.ItemStack
import org.bukkit.persistence.PersistentDataType
import kotlin.reflect.KProperty

class ItemStackProperty<T>(key: String, private val type: PersistentDataType<*, T>) {

    private val plugin = getProvidingPlugin()
    private val key = NamespacedKey(plugin, key)

    operator fun getValue(thisRef: ItemStack, property: KProperty<*>): T? {

        val meta = thisRef.itemMeta?: return null
        return meta.persistentDataContainer.get(key, type)

    }

    operator fun setValue(thisRef: ItemStack, property: KProperty<*>, value: T?) {

        if (thisRef.type.isAir) return

        thisRef.editMeta {

            if (value == null) {

                it.persistentDataContainer.remove(key)

            } else {

                it.persistentDataContainer.set(key, type, value)

            }
        }
    }

}