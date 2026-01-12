package com.leishou.solution

import org.junit.Test
import kotlin.test.assertEquals

/*
    Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer.
    The algorithm for myAtoi(string s) is as follows:
      1, Whitespace: Ignore any leading whitespace (" ").
      2, Signedness: Determine the sign by checking if the next character is '-' or '+',
         assuming positivity if neither present.
      3, Conversion: Read the integer by skipping leading zeros until a non-digit character is
         encountered or the end of the string is reached. If no digits were read, then the result is 0.
      4, Rounding: If the integer is out of the 32-bit signed integer range [-231, 231 - 1],
         then round the integer to remain in the range. Specifically, integers less than -231 should
         be rounded to -231, and integers greater than 231 - 1 should be rounded to 231 - 1.
    Return the integer as the final result.
 */
class AtoiTest {
    @Test
    fun testExample1() {
        val sol = Atoi()
        val result = sol.myAtoi("42")
        assertEquals(result, 42)
    }

    @Test
    fun testExample2() {
        val sol = Atoi()
        val result = sol.myAtoi(" -042")
        assertEquals(result, -42)
    }

    @Test
    fun testExample3() {
        val sol = Atoi()
        val result = sol.myAtoi("1337c0d3")
        assertEquals(result, 1337)
    }

    @Test
    fun testExample4() {
        val sol = Atoi()
        val result = sol.myAtoi("0-1")
        assertEquals(result, 0)
    }

    @Test
    fun testExample5() {
        val sol = Atoi()
        val result = sol.myAtoi("words and 987")
        assertEquals(result, 0)
    }

    @Test
    fun testExample6() {
        val sol = Atoi()
        val result = sol.myAtoi("-91283472332")
        assertEquals(result, -2147483648)
    }
}