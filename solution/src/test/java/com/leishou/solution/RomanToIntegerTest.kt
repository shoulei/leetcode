package com.leishou.solution

import org.junit.Test
import kotlin.test.assertEquals

class RomanToIntegerTest {
    @Test
    fun testExample1() {
        val sol = RomanToInteger()
        assertEquals(3, sol.romanToInt("III"))
    }

    @Test
    fun testExample2() {
        val sol = RomanToInteger()
        assertEquals(58, sol.romanToInt("LVIII"))
    }

    @Test
    fun testExample3() {
        val sol = RomanToInteger()
        assertEquals(1994, sol.romanToInt("MCMXCIV"))
    }
}