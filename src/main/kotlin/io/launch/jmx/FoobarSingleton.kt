@file:Suppress("unused")

package io.launch.jmx

import io.micronaut.context.annotation.Executable
import jakarta.inject.Singleton

@Singleton
class FoobarSingleton {

    // doesn't work
    @get:Executable
    @set:Executable
    var counter: Int = 0

    // works
    @Executable
    fun getCounter2(): Int = counter

    // works
    @Executable
    fun counterGet(): Int = counter

    // works
    @Executable
    fun counterSet(value: Int) { this.counter = value }
}
