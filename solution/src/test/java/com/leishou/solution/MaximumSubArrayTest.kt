package com.leishou.solution

import org.junit.Test
import kotlin.test.assertEquals

class MaximumSubArrayTest {
    @Test
    fun testExample1() {
        val sol = MaximumSubArray()
        val ret = sol.maxSubArray(intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4))
        assertEquals(ret, 6)
    }

    @Test
    fun testExample2() {
        val sol = MaximumSubArray()
        val ret = sol.maxSubArray(intArrayOf(1))
        assertEquals(ret, 1)
    }

    @Test
    fun testExample3() {
        val sol = MaximumSubArray()
        val ret = sol.maxSubArray(intArrayOf(5, 4, -1, 7, 8))
        assertEquals(ret, 23)
    }

    @Test
    fun testExample4() {
        val sol = MaximumSubArray()
        val ret = sol.maxSubArray(intArrayOf(0, -3, 1, 1))
        assertEquals(ret, 2)
    }

    @Test
    fun testExample5() {
        val sol = MaximumSubArray()
        val ret = sol.maxSubArray(intArrayOf(-1, -2, -2, -2, 3, 2, -2, 0))
        assertEquals(ret, 5)
    }

    @Test
    fun testExample6() {
        val sol = MaximumSubArray()
        val ret = sol.maxSubArray(intArrayOf(-1, 1, -3, -2, 2, -1, -2, 1, 2, -3))
        assertEquals(ret, 3)
    }
}