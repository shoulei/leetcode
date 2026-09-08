package com.leishou.solution

import org.junit.Test
import kotlin.test.assertEquals

class MaximalRectangleTest {
    @Test
    fun testExample1() {
        val charArray = arrayOf(charArrayOf('1', '0', '1', '0', '0'),
            charArrayOf('1', '0', '1', '1', '1'),
            charArrayOf('1', '1', '1', '1', '1'),
            charArrayOf('1', '0', '0', '1', '0'))
        val sol = MaximalRectangle()
        assertEquals(6, sol.maximalRectangle(charArray))
    }

    @Test
    fun testExample2() {
        val charArray = arrayOf(charArrayOf('0'))
        val sol = MaximalRectangle()
        assertEquals(0, sol.maximalRectangle(charArray))
    }

    @Test
    fun testExample3() {
        val charArray = arrayOf(charArrayOf('1'))
        val sol = MaximalRectangle()
        assertEquals(1, sol.maximalRectangle(charArray))
    }

    @Test
    fun testExample4() {
        val charArray = arrayOf(charArrayOf('1'), charArrayOf('1'))
        val sol = MaximalRectangle()
        assertEquals(2, sol.maximalRectangle(charArray))
    }

    @Test
    fun testExample5() {
        val charArray = arrayOf(charArrayOf('1', '1', '1', '1', '1', '1', '1', '1'),
            charArrayOf('1', '1', '1', '1', '1', '1' ,'1', '0'),
            charArrayOf('1', '1', '1', '1', '1', '1', '1', '0'),
            charArrayOf('1', '1', '1', '1', '1', '0', '0', '0'),
            charArrayOf('0', '1', '1', '1', '1', '0', '0', '0'))
        val sol = MaximalRectangle()
        assertEquals(21, sol.maximalRectangle(charArray))
    }
}