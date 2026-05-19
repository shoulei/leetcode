package com.leishou.solution

import org.junit.Test
import kotlin.test.assertEquals

class LongestCommonPrefixTest {
    @Test
    fun testExample1() {
        val sol = LongestCommonPrefix()
        val ret = sol.longestCommonPrefix(arrayOf("flower","flow","flight"))
        assertEquals(ret, "fl")
    }

    @Test
    fun testExample2() {
        val sol = LongestCommonPrefix()
        val ret = sol.longestCommonPrefix(arrayOf("dog","racecar","car"))
        assertEquals(ret, "")
    }
}