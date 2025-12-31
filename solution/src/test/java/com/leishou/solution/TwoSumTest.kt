package com.leishou.solution

import org.junit.Assert.assertArrayEquals
import org.junit.Test

class TwoSumTest {
    @Test
    fun testExample1() {
        val sol = TwoSum()
        val result = sol.twoSum(intArrayOf(2, 7, 11, 15), 9).sortedArray()
        assertArrayEquals(intArrayOf(0, 1), result)
    }

    @Test
    fun testExample2() {
        val sol = TwoSum()
        val result = sol.twoSum(intArrayOf(3, 2, 4), 6).sortedArray()
        assertArrayEquals(intArrayOf(1, 2), result)
    }

    @Test
    fun testExample3() {
        val sol = TwoSum()
        val result = sol.twoSum(intArrayOf(3, 3), 6).sortedArray()
        assertArrayEquals(intArrayOf(0, 1), result)
    }
}