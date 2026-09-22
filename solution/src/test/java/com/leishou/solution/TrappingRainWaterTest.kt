package com.leishou.solution

import org.junit.Test
import kotlin.test.assertEquals

class TrappingRainWaterTest {
    @Test
    fun testExample1() {
        val sol = TrappingRainWater()
        assertEquals(6, sol.trap(intArrayOf(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1)))
    }

    @Test
    fun testExample2() {
        val sol = TrappingRainWater()
        assertEquals(9, sol.trap(intArrayOf(4, 2, 0, 3, 2, 5)))
    }
}