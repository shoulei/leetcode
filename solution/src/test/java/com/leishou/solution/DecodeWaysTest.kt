package com.leishou.solution

import org.junit.Test
import kotlin.test.assertEquals

class DecodeWaysTest {
    @Test
    fun testExample1() {
        val sol = DecodeWays()
        assertEquals(2, sol.numDecodings("12"))
    }

    @Test
    fun testExample2() {
        val sol = DecodeWays()
        assertEquals(3, sol.numDecodings("226"))
    }

    @Test
    fun testExample3() {
        val sol = DecodeWays()
        assertEquals(0, sol.numDecodings("06"))
    }

    @Test
    fun testExample4() {
        val sol = DecodeWays()
        assertEquals(1836311903, sol.numDecodings("111111111111111111111111111111111111111111111"))
    }

    @Test
    fun testExample5() {
        val sol = DecodeWays()
        assertEquals(1, sol.numDecodings("2101"))
    }
}