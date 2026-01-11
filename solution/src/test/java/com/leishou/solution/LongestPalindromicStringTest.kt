package com.leishou.solution

import org.junit.Test
import kotlin.test.assertTrue
/*
    Given a string s, return the longest palindromic substring in s.
 */
class LongestPalindromicStringTest {
    @Test
    fun testExample1() {
        val sol = LongestPalindromicString()
        val result = sol.longestPalindrome("babad")
        assertTrue (result == "bab" || result == "aba")
    }

    @Test
    fun testExample2() {
        val sol = LongestPalindromicString()
        val result = sol.longestPalindrome("cbbd")
        assertTrue (result == "bb")
    }
}