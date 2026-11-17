package com.leishou.solution

import org.junit.Test
import kotlin.test.assertEquals

class SearchA2dMatrixTest {
    @Test
    fun testExample1() {
        val matrix = arrayOf(intArrayOf(1, 3, 5, 7), intArrayOf(10, 11, 16, 20),
            intArrayOf(23, 30, 34, 60))
        assertEquals(true, SearchA2dMatrix().searchMatrix(matrix, 3))
    }

    @Test
    fun testExample2() {
        val matrix = arrayOf(intArrayOf(1, 3, 5, 7), intArrayOf(10, 11, 16, 20),
            intArrayOf(23, 30, 34, 60))
        assertEquals(false, SearchA2dMatrix().searchMatrix(matrix, 13))
    }

    @Test
    fun testExample3() {
        val matrix = arrayOf(intArrayOf(1, 3, 5, 7), intArrayOf(10, 11, 16, 20),
            intArrayOf(23, 30, 34, 60))
        assertEquals(true, SearchA2dMatrix().searchMatrix(matrix, 11))
    }

    @Test
    fun testExample4() {
        val matrix = arrayOf(intArrayOf(1, 3))
        assertEquals(true, SearchA2dMatrix().searchMatrix(matrix, 3))
    }

    @Test
    fun testExample5() {
        val matrix = arrayOf(intArrayOf(1), intArrayOf(3))
        assertEquals(true, SearchA2dMatrix().searchMatrix(matrix, 3))
    }
}