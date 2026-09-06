package com.leishou.solution

import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class GrayCodeTest {
    @Test
    fun testExample1() {
        val ret = GrayCode().grayCode(2)
        assertTrue(ret == listOf(0, 1, 3, 2) || ret == listOf(0, 2, 3, 1))
    }

    @Test
    fun testExample2() {
        val ret = GrayCode().grayCode(1)
        assertEquals(listOf(0, 1), ret)
    }
}