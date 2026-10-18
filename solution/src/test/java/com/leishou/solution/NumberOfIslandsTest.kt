package com.leishou.solution

import org.junit.Test
import kotlin.test.assertEquals

class NumberOfIslandsTest {
    @Test
    fun testExample1() {
        val sol = NumberOfIslands()
        val grid = arrayOf(charArrayOf('1', '1', '1', '1', '0'),
            charArrayOf('1', '1', '0', '1', '0'),
            charArrayOf('1', '1', '0', '0', '0'),
            charArrayOf('0', '0', '0', '0', '0'))
        assertEquals(1, sol.numIslands(grid))
    }

    @Test
    fun testExample2() {
        val sol = NumberOfIslands()
        val grid = arrayOf(charArrayOf('1', '1', '0', '0', '0'),
            charArrayOf('1', '1', '0', '0', '0'),
            charArrayOf('0', '0', '1', '0', '0'),
            charArrayOf('0', '0', '0', '1', '1'))
        assertEquals(3, sol.numIslands(grid))
    }
}