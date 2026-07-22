package com.leishou.solution

import org.junit.Test
import kotlin.test.assertContentEquals

class SpiralMatrixTest {
    @Test
    fun testExample1() {
        val sol = SpiralMatrix()
        val ret = sol.spiralOrder(arrayOf(intArrayOf(1, 2, 3), intArrayOf(4, 5, 6), intArrayOf(7, 8, 9)))
        assertContentEquals(ret, listOf(1, 2, 3, 6, 9, 8, 7, 4, 5))
    }

    @Test
    fun testExample2() {
        val sol = SpiralMatrix()
        val ret = sol.spiralOrder(arrayOf(intArrayOf(1, 2, 3, 4), intArrayOf(5, 6, 7, 8), intArrayOf(9, 10, 11, 12)))
        assertContentEquals(ret, listOf(1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7))
    }

    @Test
    fun testExample3() {
        val sol = SpiralMatrix()
        val ret = sol.spiralOrder(arrayOf(intArrayOf(3), intArrayOf(2)))
        assertContentEquals(ret, listOf(3, 2))
    }
}