package com.leishou.solution

import org.junit.Test
import kotlin.test.assertContentEquals

class NextGreaterElementIITest {
    @Test
    fun testExample1() {
        val sol = NextGreaterElementII()
        val result = sol.nextGreaterElements(intArrayOf(1, 2, 1))
        assertContentEquals(intArrayOf(2, -1, 2), result)
    }

    @Test
    fun testExample2() {
        val sol = NextGreaterElementII()
        val result = sol.nextGreaterElements(intArrayOf(1, 2, 3, 4, 3))
        assertContentEquals(intArrayOf(2, 3, 4, -1, 4), result)
    }
}