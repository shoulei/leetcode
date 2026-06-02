package com.leishou.solution

import org.junit.Test
import kotlin.test.assertContentEquals

class LetterCombinationsTest {
    @Test
    fun testExample1() {
        val sol = LetterCombinations()
        val result = sol.letterCombinations("23")
        assertContentEquals(result, listOf("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"))
    }

    fun testExample2() {
        val sol = LetterCombinations()
        val result = sol.letterCombinations("2")
        assertContentEquals(result, listOf("a", "b", "c"))
    }
}