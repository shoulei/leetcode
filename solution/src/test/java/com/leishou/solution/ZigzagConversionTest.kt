package com.leishou.solution

import org.junit.Test
import kotlin.test.assertEquals

/*
    The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
    (you may want to display this pattern in a fixed font for better legibility)
 */
class ZigzagConversionTest {
    @Test
    fun testExample1() {
        val sol = ZigzagConversion()
        val result = sol.convert("PAYPALISHIRING", 3)
        assertEquals(result, "PAHNAPLSIIGYIR")
    }

    @Test
    fun testExample2() {
        val sol = ZigzagConversion()
        val result = sol.convert("PAYPALISHIRING", 4)
        assertEquals(result, "PINALSIGYAHRPI")
    }
}