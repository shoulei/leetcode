package com.leishou.solution

import org.junit.Test
import kotlin.test.assertEquals

/*
    Given an input string s and a pattern p, implement regular expression matching with support for
    '.' and '*' where:
    1, '.' Matches any single character.
    2, '*' Matches zero or more of the preceding element.
    The matching should cover the entire input string (not partial).
*/
class RegularExpressMatchTest {
    @Test
    fun testExample1() {
        val sol = RegularExpressMatch()
        val result = sol.isMatch("aa", "a")
        assertEquals(result, false)
    }

    @Test
    fun testExample2() {
        val sol = RegularExpressMatch()
        val result = sol.isMatch("aa", "a*")
        assertEquals(result, true)
    }

    @Test
    fun testExample3() {
        val sol = RegularExpressMatch()
        val result = sol.isMatch("ab", ".*")
        assertEquals(result, true)
    }

    @Test
    fun testExample4() {
        val sol = RegularExpressMatch()
        val result = sol.isMatch("aa", "a")
        assertEquals(result, false)
    }

    @Test
    fun testExample6() {
        val sol = RegularExpressMatch()
        val result = sol.isMatch("aab", "c*a*b")
        assertEquals(result, true)
    }

    @Test
    fun testExample7() {
        val sol = RegularExpressMatch()
        val result = sol.isMatch("mississippi", "mis*is*ip*.")
        assertEquals(result, true)
    }

    @Test
    fun testExample8() {
        val sol = RegularExpressMatch()
        val result = sol.isMatch("ab", ".*")
        assertEquals(result, true)
    }

    @Test
    fun testExample9() {
        val sol = RegularExpressMatch()
        val result = sol.isMatch("aaa", "a*a")
        assertEquals(result, true)
    }

    @Test
    fun testExample10() {
        val sol = RegularExpressMatch()
        val result = sol.isMatch("ccabab", ".*ab")
        assertEquals(result, true)
    }

    @Test
    fun testExample11() {
        val sol = RegularExpressMatch()
        val result = sol.isMatch("aaabb", "a*aaa*abb")
        assertEquals(result, true)
    }

    @Test
    fun testExample12() {
        val sol = RegularExpressMatch()
        val result = sol.isMatch("mississippi", "mis*is*p*.")
        assertEquals(result, false)
    }

    @Test
    fun testExample13() {
        val sol = RegularExpressMatch()
        val result = sol.isMatch("a", ".*..a*")
        assertEquals(result, false)
    }
}