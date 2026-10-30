package com.leishou.solution

import org.junit.Test
import kotlin.test.assertEquals

class MaxPointsOnALineTest {
    @Test
    fun testExample1() {
        val points = arrayOf(intArrayOf(1, 1), intArrayOf(2, 2), intArrayOf(3, 3))
        assertEquals(3, MaxPointsOnALine().maxPoints(points))
    }

    @Test
    fun testExample2() {
        val points = arrayOf(intArrayOf(1, 1), intArrayOf(3, 2), intArrayOf(5, 3),
            intArrayOf(4, 1), intArrayOf(2, 3), intArrayOf(1, 4))
        assertEquals(4, MaxPointsOnALine().maxPoints(points))
    }

    @Test
    fun testExample3() {
        val points = arrayOf(intArrayOf(0, 0), intArrayOf(1, -1), intArrayOf(1, 1))
        assertEquals(2, MaxPointsOnALine().maxPoints(points))
    }

    @Test
    fun testExample4() {
        val points = arrayOf(intArrayOf(-9, -651), intArrayOf(-4, -4), intArrayOf(-8, -582),
            intArrayOf(9, 591), intArrayOf(-3, 3))
        assertEquals(3, MaxPointsOnALine().maxPoints(points))
    }

    @Test
    fun testExample5() {
        val points = arrayOf(intArrayOf(2, 1), intArrayOf(2, 2), intArrayOf(2, 3),
            intArrayOf(3, 1), intArrayOf(3, 2), intArrayOf(3, 3), intArrayOf(3, 4))
        assertEquals(4, MaxPointsOnALine().maxPoints(points))
    }
}