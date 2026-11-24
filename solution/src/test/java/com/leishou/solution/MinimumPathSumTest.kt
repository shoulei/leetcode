package com.leishou.solution

import org.junit.Test
import kotlin.test.assertEquals

class MinimumPathSumTest {
    @Test
    fun testExample1() {
        val grid = arrayOf(intArrayOf(1, 3, 1), intArrayOf(1, 5, 1), intArrayOf(4, 2, 1))
        assertEquals(7, MinimumPathSum().minPathSum(grid))
    }

    @Test
    fun testExample2() {
        val grid = arrayOf(intArrayOf(1, 2, 3), intArrayOf(4, 5, 6))
        assertEquals(12, MinimumPathSum().minPathSum(grid))
    }
}