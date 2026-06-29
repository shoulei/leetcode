package com.leishou.solution

import org.junit.Test
import kotlin.test.assertEquals

class DivideTwoIntegersTest {
    @Test
    fun testExample1() {
        val sol = DivideTwoIntegers()
        val result = sol.divide(10, 3)
        assertEquals(3, result)
    }

    @Test
    fun testExample2() {
        val sol = DivideTwoIntegers()
        val result = sol.divide(7, -3)
        assertEquals(-2, result)
    }
}