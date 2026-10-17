package com.leishou.solution

import org.junit.Test
import kotlin.test.assertEquals

/*
    Given a string s, find the length of the longest substring without duplicate characters.
 */
class LongestSubstringTest {
    @Test
    fun testExample1() {
        val sol = LongestSubstring()
        assertEquals(3, sol.lengthOfLongestSubstring("abcabcbb"))
    }

    @Test
    fun testExample2() {
        val sol = LongestSubstring()
        assertEquals(1, sol.lengthOfLongestSubstring("bbbbb"))
    }

    @Test
    fun testExample3() {
        val sol = LongestSubstring()
        assertEquals(3, sol.lengthOfLongestSubstring("pwwkew"))
    }

    @Test
    fun testExample4() {
        val sol = LongestSubstring()
        assertEquals(2, sol.lengthOfLongestSubstring("abba"))
    }

    @Test
    fun testExample5() {
        val sol = LongestSubstring()
        assertEquals(2, sol.lengthOfLongestSubstring("aab"))
    }

    @Test
    fun testExample6() {
        val sol = LongestSubstring()
        assertEquals(4, sol.lengthOfLongestSubstring("1R1T7"))
    }
}