package com.leishou.solution

import org.junit.Test
import kotlin.test.assertContentEquals

class SlideWindowTest {
    @Test
    fun testExample1() {
        val sol = SlideWindow()
        val result = sol.getMaxNumbersArray(intArrayOf(1, 3, -1, -3, 5, 3, 6, 7), 3)
        assertContentEquals(result, intArrayOf(3, 3, 5, 5, 6, 7))
    }

    @Test
    fun testExample2() {
        val sol = SlideWindow()
        val result = sol.getMaxNumbersArray(intArrayOf(1, 3, -1, 0, 1, 2), 3)
        assertContentEquals(result, intArrayOf(3, 3, 1, 2))
    }
}