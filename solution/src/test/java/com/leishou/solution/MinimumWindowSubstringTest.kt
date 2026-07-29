package com.leishou.solution

import org.junit.Test
import kotlin.test.assertEquals

class MinimumWindowSubstringTest {
    @Test
    fun testExample1() {
        val sol = MinimumWindowSubstring()
        val ret = sol.minWindow("ADOBECODEBANC", "ABC")
        assertEquals("BANC", ret)
    }

    @Test
    fun testExample2() {
        val sol = MinimumWindowSubstring()
        val ret = sol.minWindow("a", "a")
        assertEquals("a", ret)
    }

    @Test
    fun testExample3() {
        val sol = MinimumWindowSubstring()
        val ret = sol.minWindow("a", "aa")
        assertEquals("", ret)
    }

    @Test
    fun testExample4() {
        val sol = MinimumWindowSubstring()
        val ret = sol.minWindow("cabwefgewcwaefgcf", "cae")
        assertEquals( "cwae", ret)
    }

    @Test
    fun testExample5() {
        val sol = MinimumWindowSubstring()
        val ret = sol.minWindow("bbaac", "aba")
        assertEquals("baa", ret)
    }
}