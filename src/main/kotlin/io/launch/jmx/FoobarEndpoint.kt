@file:Suppress("unused")

package io.launch.jmx

import io.micronaut.management.endpoint.annotation.Endpoint
import io.micronaut.management.endpoint.annotation.Read
import io.micronaut.management.endpoint.annotation.Write

@Endpoint("foobar")
class FoobarEndpoint {

    // doesn't work
    @get:Read
    @set:Write
    var counter: Int = 0

    // works
    @Read
    fun getCounter2(): Int = counter

    // works
    @Read
    fun counterGet(): Int = counter

    // works
    @Write
    fun counterSet(value: Int) { this.counter = value }
}
