package com.leishou.solution

import org.junit.Test
import kotlin.test.assertEquals

class LongestValidParenthesesTest {
    @Test
    fun testExample1() {
        val sol = LongestValidParentheses()
        val ret = sol.longestValidParentheses("(()")
        assertEquals(ret, 2)
    }

    @Test
    fun testExample2() {
        val sol = LongestValidParentheses()
        val ret = sol.longestValidParentheses(")()())")
        assertEquals(ret, 4)
    }

    @Test
    fun testExample3() {
        val sol = LongestValidParentheses()
        val ret = sol.longestValidParentheses("")
        assertEquals(ret, 0)
    }

    @Test
    fun testExample4() {
        val sol = LongestValidParentheses()
        val ret = sol.longestValidParentheses("()(())")
        assertEquals(ret, 6)
    }

    @Test
    fun testExample5() {
        val sol = LongestValidParentheses()
        val ret = sol.longestValidParentheses("(()())")
        assertEquals(ret, 6)
    }

    @Test
    fun testExample6() {
        val sol = LongestValidParentheses()
        val ret = sol.longestValidParentheses("((()))())")
        assertEquals(ret, 8)
    }
}