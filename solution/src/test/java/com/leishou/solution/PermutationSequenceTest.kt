package com.leishou.solution

import org.junit.Test
import kotlin.test.assertEquals

class PermutationSequenceTest {
    @Test
    fun testExample1() {
        val sol = PermutationSequence()
        val ret = sol.getPermutation(3, 1)
        assertEquals("123", ret)
    }

    @Test
    fun testExample2() {
        val sol = PermutationSequence()
        val ret = sol.getPermutation(3, 3)
        assertEquals("213", ret)
    }

    @Test
    fun testExample3() {
        val sol = PermutationSequence()
        val ret = sol.getPermutation(4, 9)
        assertEquals("2314", ret)
    }
}