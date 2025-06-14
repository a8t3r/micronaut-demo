package io.launch.jmx
import io.micronaut.context.AbstractInitializableBeanDefinitionAndReference
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DemoTest {

    @Suppress("UNCHECKED_CAST")
    private inline fun <reified T> instance(): AbstractInitializableBeanDefinitionAndReference<T> {
        return Class.forName(/* className = */ "${T::class.java.`package`.name}.$${T::class.simpleName}\$Definition")
            .getDeclaredConstructor().newInstance() as AbstractInitializableBeanDefinitionAndReference<T>
    }

    @Test
    fun endpoint() {
        val foobar = instance<FoobarEndpoint>()
        assertEquals(foobar.injectedMethods.size, 1)
        assertEquals(foobar.executableMethods.size, 3)
        assertEquals(foobar.executableMethods.map { it.name }, listOf("getCounter2", "counterGet", "counterSet"))
    }

    @Test
    fun singleton() {
        val foobar = instance<FoobarSingleton>()
        assertEquals(foobar.injectedMethods.size, 0)
        assertEquals(foobar.executableMethods.size, 3)
        assertEquals(foobar.executableMethods.map { it.name }, listOf("getCounter2", "counterGet", "counterSet"))
    }
}
