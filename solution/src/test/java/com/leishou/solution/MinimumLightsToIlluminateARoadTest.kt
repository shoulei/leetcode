package com.leishou.solution

import org.junit.Test
import kotlin.test.assertEquals

class MinimumLightsToIlluminateARoadTest {
    @Test
    fun testExample1() {
        val lights = intArrayOf(0, 0, 0, 0)
        assertEquals(2, MinimumLightsToIlluminateARoad().minLights(lights))
    }

    @Test
    fun testExample2() {
        val lights = intArrayOf(0, 0, 0, 2, 0)
        assertEquals(1, MinimumLightsToIlluminateARoad().minLights(lights))
    }

    @Test
    fun testExample3() {
        val lights = intArrayOf(0, 0, 0)
        assertEquals(1, MinimumLightsToIlluminateARoad().minLights(lights))
    }

    @Test
    fun testExample4() {
        val lights = intArrayOf(0, 0, 2)
        assertEquals(0, MinimumLightsToIlluminateARoad().minLights(lights))
    }

    @Test
    fun testExample5() {
        val lights = intArrayOf(0, 0, 0, 0, 3, 6)
        assertEquals(0, MinimumLightsToIlluminateARoad().minLights(lights))
    }
}