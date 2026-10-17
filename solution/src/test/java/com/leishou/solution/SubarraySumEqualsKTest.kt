package com.leishou.solution

import org.junit.Test
import kotlin.test.assertEquals

class SubarraySumEqualsKTest {
    @Test
    fun testExample1() {
        assertEquals(2, SubarraySumEqualsK().subarraySum(intArrayOf(1, 1, 1), 2))
    }

    @Test
    fun testExample2() {
        assertEquals(2, SubarraySumEqualsK().subarraySum(intArrayOf(1, 2, 3), 3))
    }

    @Test
    fun testExample3() {
        assertEquals(4, SubarraySumEqualsK().subarraySum(intArrayOf(1, 2, 1, 2, 1), 3))
    }
}