package com.leishou.solution

import org.junit.Test
import kotlin.test.assertEquals

class NumArrayTest {
    @Test
    fun testExample1() {
        val sum = NumArray(intArrayOf(-2, 0, 3, -5, 2, -1))
        assertEquals(1, sum.sumRange(0, 2))
        assertEquals(-1, sum.sumRange(2, 5))
        assertEquals(-3, sum.sumRange(0, 5))
    }
}