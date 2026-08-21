package com.leishou.solution

import org.junit.Test
import kotlin.test.assertEquals

class GenerateParenthesesTest {
    @Test
    fun testExample1() {
        val sol = GenerateParentheses()
        assertEquals(listOf("((()))", "(()())", "(())()", "()(())", "()()()"), sol.generateParenthesis(3))
    }

    @Test
    fun testExample2() {
        val sol = GenerateParentheses()
        assertEquals(listOf("()"), sol.generateParenthesis(1))
    }
}