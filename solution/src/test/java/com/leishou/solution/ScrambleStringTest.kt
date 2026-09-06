package com.leishou.solution

import org.junit.Test
import kotlin.test.assertEquals

class ScrambleStringTest {
    @Test
    fun testExample1() {
        val sol = ScrambleString()
        assertEquals(true, sol.isScramble("great", "rgeat"))
    }

    @Test
    fun testExample2() {
        val sol = ScrambleString()
        assertEquals(true, sol.isScramble("a", "a"))
    }

    @Test
    fun testExample3() {
        val sol = ScrambleString()
        assertEquals(false, sol.isScramble("abcde", "caebd"))
    }
}