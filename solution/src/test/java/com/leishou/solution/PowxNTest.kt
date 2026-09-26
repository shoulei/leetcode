package com.leishou.solution

import org.junit.Test
import kotlin.test.assertEquals

class PowxNTest {
    @Test
    fun testExample1() {
        assertEquals(1024.00000, PowxN().myPow(2.00000, 10))
    }

    @Test
    fun testExample2() {
        assertEquals(0.25000, PowxN().myPow(2.00000, -2))
    }

    @Test
    fun testExample3() {
        assertEquals(0.0, PowxN().myPow(2.00000, -2147483648))
    }

    @Test
    fun testExample4() {
        assertEquals(-1.00000, PowxN().myPow(-1.00000, 2147483647))
    }
}