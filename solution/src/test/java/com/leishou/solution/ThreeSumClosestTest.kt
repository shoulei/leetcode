package com.leishou.solution

import org.junit.Test
import kotlin.test.assertEquals

class ThreeSumClosestTest {
    @Test
    fun testExample1() {
        val sol = ThreeSumClosest()
        val result = sol.threeSumClosest(intArrayOf(-1, 2, 1, -4), 1)
        assertEquals(2, result)
    }

    @Test
    fun testExample2() {
        val sol = ThreeSumClosest()
        val result = sol.threeSumClosest(intArrayOf(0, 0, 0), 1)
        assertEquals(0, result)
    }
}