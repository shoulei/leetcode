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
        assertEquals(sol.lengthOfLongestSubstring("abcabcbb"), 3)
    }

    @Test
    fun testExample2() {
        val sol = LongestSubstring()
        assertEquals(sol.lengthOfLongestSubstring("bbbbb"), 1)
    }

    @Test
    fun testExample3() {
        val sol = LongestSubstring()
        assertEquals(sol.lengthOfLongestSubstring("pwwkew"), 3)
    }

    @Test
    fun testExample4() {
        val sol = LongestSubstring()
        assertEquals(sol.lengthOfLongestSubstring("abba"), 2)
    }


    @Test
    fun testExample5() {
        val sol = LongestSubstring()
        assertEquals(sol.lengthOfLongestSubstring("aab"), 2)
    }
}