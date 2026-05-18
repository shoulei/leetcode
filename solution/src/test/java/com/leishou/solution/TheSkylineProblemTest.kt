package com.leishou.solution

import org.junit.Test
import kotlin.test.assertContentEquals

class TheSkylineProblemTest {
    @Test
    fun testExample1() {
        val sol = TheSkylineProblem()
        val buildings = arrayOf(
            intArrayOf(2, 9, 10),
            intArrayOf(3, 7, 15),
            intArrayOf(5, 12, 12),
            intArrayOf(15, 20, 10),
            intArrayOf(19, 24, 8)
        )

        val result = sol.getSkyline(buildings)

        val expected = listOf(
            listOf(2, 10),
            listOf(3, 15),
            listOf(7, 12),
            listOf(12, 0),
            listOf(15, 10),
            listOf(20, 8),
            listOf(24, 0)
        )

        assertContentEquals(expected, result)
    }

    @Test
    fun testExample2() {
        val sol = TheSkylineProblem()
        val buildings = arrayOf(
            intArrayOf(0, 2, 3),
            intArrayOf(2, 5, 3)
        )

        val result = sol.getSkyline(buildings)

        val expected = listOf(
            listOf(0, 3),
            listOf(5, 0)
        )

        assertContentEquals(expected, result)
    }

    @Test
    fun testExample3() {
        val sol = TheSkylineProblem()
        val buildings = arrayOf(
            intArrayOf(1, 2, 1),
            intArrayOf(1, 2, 2),
            intArrayOf(1, 2, 3)
        )

        val result = sol.getSkyline(buildings)

        val expected = listOf(
            listOf(1, 3),
            listOf(2, 0)
        )

        assertContentEquals(expected, result)
    }

    @Test
    fun testExample4() {
        val sol = TheSkylineProblem()
        val buildings = arrayOf(
            intArrayOf(0, 2, 5),
            intArrayOf(0, 2, 3),
            intArrayOf(2, 3, 4)
        )

        val result = sol.getSkyline(buildings)

        val expected = listOf(
            listOf(0, 5),
            listOf(2, 4),
            listOf(3, 0),
        )

        assertContentEquals(expected, result)
    }
}