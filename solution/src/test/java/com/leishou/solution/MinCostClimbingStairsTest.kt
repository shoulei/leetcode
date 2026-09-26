package com.leishou.solution

import org.junit.Test
import kotlin.test.assertEquals

class MinCostClimbingStairsTest {
    @Test
    fun testExample1() {
        assertEquals(15, MinCostClimbingStairs().minCostClimbingStairs(intArrayOf(10, 15, 20)))
    }

    @Test
    fun testExample2() {
        assertEquals(6, MinCostClimbingStairs().minCostClimbingStairs(intArrayOf(1, 100, 1, 1, 1, 100, 1, 1, 100, 1)))
    }

    @Test
    fun testExample3() {
        assertEquals(0, MinCostClimbingStairs().minCostClimbingStairs(intArrayOf(100)))
    }
}