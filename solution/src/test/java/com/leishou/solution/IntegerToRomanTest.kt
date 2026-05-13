package com.leishou.solution

import org.junit.Test
import kotlin.test.assertEquals

class IntegerToRomanTest {
    @Test
    fun testExample1() {
        val sol = IntegerToRoman()
        val result = sol.intToRoman(3)
        assertEquals(result, "III")
    }

    @Test
    fun testExample2() {
        val sol = IntegerToRoman()
        val result = sol.intToRoman(3749)
        assertEquals(result, "MMMDCCXLIX")
    }

    @Test
    fun testExample3() {
        val sol = IntegerToRoman()
        val result = sol.intToRoman(58)
        assertEquals(result, "LVIII")
    }

    @Test
    fun testExample4() {
        val sol = IntegerToRoman()
        val result = sol.intToRoman(1994)
        assertEquals(result, "MCMXCIV")
    }
}