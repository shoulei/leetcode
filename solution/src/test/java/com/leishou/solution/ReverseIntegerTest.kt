package com.leishou.solution

import org.junit.Test
import kotlin.test.assertEquals

/*
    Given a signed 32-bit integer x, return x with its digits reversed.
    If reversing x causes the value to go outside the signed 32-bit integer range [-2^31, 2^31 - 1],
    then return 0.
 */
class ReverseIntegerTest {
    @Test
    fun testExample1() {
        val ret = ReverseInteger().reverse(123)
        assertEquals(ret, 321)
    }

    @Test
    fun testExample2() {
        val ret = ReverseInteger().reverse(-123)
        assertEquals(ret, -321)
    }

    @Test
    fun testExample3() {
        val ret = ReverseInteger().reverse(120)
        assertEquals(ret, 21)
    }

    @Test
    fun testExample4() {
        val ret = ReverseInteger().reverse(2147483647)
        assertEquals(ret, 0)
    }
}