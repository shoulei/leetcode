package com.leishou.solution

import org.junit.Test
import kotlin.test.assertContentEquals

class FourSumTest {
    @Test
    fun testExample1() {
        val sol = FourSum()
        val result = sol.fourSum(intArrayOf(1, 0, -1, 0, -2, 2), 0)
        assertContentEquals(result, listOf(listOf(-2, -1, 1, 2), listOf(-2, 0, 0, 2), listOf(-1, 0, 0, 1)))
    }

    @Test
    fun testExample2() {
        val sol = FourSum()
        val result = sol.fourSum(intArrayOf(-2, -1, -1, 1, 1, 2, 2), 0)
        assertContentEquals(result, listOf(listOf(-2, -1, 1, 2), listOf(-1, -1, 1, 1)))
    }

    @Test
    fun testExample3() {
        val sol = FourSum()
        val result = sol.fourSum(intArrayOf(1000000000, 1000000000, 1000000000, 1000000000), -294967296)
        assertContentEquals(result, emptyList())
    }
}