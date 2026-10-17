package com.leishou.solution

import org.junit.Test
import kotlin.test.assertContentEquals

class ProductOfArrayExceptSelfTest {
    @Test
    fun testExample1() {
        assertContentEquals(intArrayOf(24, 12, 8, 6), ProductOfArrayExceptSelf().productExceptSelf(
            intArrayOf(1, 2, 3, 4)))
    }

    @Test
    fun testExample2() {
        assertContentEquals(intArrayOf(0, 0, 9, 0, 0), ProductOfArrayExceptSelf().productExceptSelf(
            intArrayOf(-1, 1, 0, -3, 3)))
    }
}