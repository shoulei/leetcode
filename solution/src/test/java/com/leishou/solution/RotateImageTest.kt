package com.leishou.solution

import org.junit.Test
import kotlin.test.assertContentEquals
import kotlin.test.assertEquals

class RotateImageTest {
    @Test
    fun testExample1() {
        val sol = RotateImage()
        val matrix = arrayOf(intArrayOf(1, 2, 3), intArrayOf(4, 5, 6), intArrayOf(7, 8, 9))
        sol.rotate(matrix)
        val expected = arrayOf(intArrayOf(7, 4, 1), intArrayOf(8, 5, 2), intArrayOf(9, 6, 3))
        assertEquals(expected.map { it.toList() }, matrix.map { it.toList() })
    }

    @Test
    fun testExample2() {
        val sol = RotateImage()
        val matrix = arrayOf(intArrayOf(5, 1, 9, 11), intArrayOf(2, 4, 8, 10),
            intArrayOf(13, 3, 6, 7), intArrayOf(15, 14, 12, 16))
        sol.rotate(matrix)
        val expected = arrayOf(intArrayOf(15, 13, 2, 5), intArrayOf(14, 3, 4, 1),
            intArrayOf(12, 6, 8, 9), intArrayOf(16, 7, 10, 11))
        assertEquals(expected.map { it.toList() }, matrix.map { it.toList() })
    }

    @Test
    fun testExample3() {
        val sol = RotateImage()
        val matrix = arrayOf(intArrayOf(1, 2, 3, 4, 5), intArrayOf(6, 7, 8, 9, 10),
            intArrayOf(11, 12, 13, 14, 15), intArrayOf(16, 17, 18, 19, 20),
            intArrayOf(21, 22, 23, 24, 25))
        sol.rotate(matrix)
        val expected = arrayOf(intArrayOf(21, 16, 11, 6, 1), intArrayOf(22, 17, 12, 7, 2),
            intArrayOf(23, 18, 13, 8, 3), intArrayOf(24, 19, 14, 9, 4),
            intArrayOf(25, 20, 15, 10, 5))
        assertEquals(expected.map { it.toList() }, matrix.map { it.toList() })
    }
}