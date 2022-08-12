package net.gorayan.mc.paperkotlinutils

import org.bukkit.scheduler.BukkitRunnable

fun bukkitRunnableTimer(
    lifetime: Int = Int.MAX_VALUE - 1,
    delay: Long = 0,
    period: Long = 0,
    task: Task
): Runnable {

    val handle = object : BukkitRunnable() {

        private var lifetime = 0

        init {

        }

        override fun run() {

            task()

            if (lifetime > this.lifetime) {

                this.lifetime ++
                return

            }

            cancel()

        }

        fun start() = runTaskTimer(getProvidingPlugin(), delay, period)

    }

    handle.start()

    return RunnableWrapper(handle)

}

fun bukkitRunnableLater(
    delay: Long = 0,
    task: Task
): Runnable {

    val handle = object : BukkitRunnable() {

        override fun run() = task()

        fun start() = runTaskLater(getProvidingPlugin(), delay)

    }

    handle.start()

    return RunnableWrapper(handle)

}

fun bukkitRunnable(
    task: Task
) = bukkitRunnableLater(task = task)

typealias Task = () -> Unit

private class RunnableWrapper(private val handle: BukkitRunnable) : Runnable {

    override val isCancelled: Boolean get() = handle.isCancelled

    override fun cancel() = handle.cancel()

}

interface Runnable {

    val isCancelled: Boolean

    fun cancel()

}