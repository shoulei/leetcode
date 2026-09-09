package com.leishou.solution

import org.junit.Test
import kotlin.test.assertEquals

class LargestRectangleInHistogramTest {
    @Test
    fun testExample1() {
        val sol = LargestRectangleInHistogram()
        assertEquals(10, sol.largestRectangleArea(intArrayOf(2, 1, 5, 6, 2, 3)))
    }

    @Test
    fun testExample2() {
        val sol = LargestRectangleInHistogram()
        assertEquals(4, sol.largestRectangleArea(intArrayOf(2, 4)))
    }
}