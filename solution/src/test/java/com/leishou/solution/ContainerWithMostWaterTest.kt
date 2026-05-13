package com.leishou.solution

import org.junit.Test
import kotlin.test.assertEquals

class ContainerWithMostWaterTest {
    @Test
    fun testExample1() {
        val sol = ContainerWithMostWater()
        val result = sol.maxArea(intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7))
        assertEquals(result, 49)
    }

    @Test
    fun testExample2() {
        val sol = ContainerWithMostWater()
        val result = sol.maxArea(intArrayOf(1, 1))
        assertEquals(result, 1)
    }
}