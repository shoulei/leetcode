package com.leishou.solution

import org.junit.Test
import kotlin.test.assertContentEquals

class ThreeSumTest {
    @Test
    fun testExample1() {
        val sol = ThreeSum()
        val result = sol.threeSum(intArrayOf(-1, 0, 1, 2, -1, -4))
        assertContentEquals(listOf(listOf(-1, -1, 2), listOf(-1, 0, 1)), result)
    }

    @Test
    fun testExample2() {
        val sol = ThreeSum()
        val result = sol.threeSum(intArrayOf(0, 0, 0))
        assertContentEquals(listOf(listOf(0, 0, 0)), result)
    }
}