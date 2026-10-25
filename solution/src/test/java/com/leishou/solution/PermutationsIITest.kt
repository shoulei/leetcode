package com.leishou.solution

import org.junit.Test
import kotlin.test.assertEquals

class PermutationsIITest {
    @Test
    fun testExample1() {
        val sol = PermutationsII()
        val array = intArrayOf(1, 2, 3)
        val expected = listOf(listOf(1, 2, 3), listOf(1, 3, 2), listOf(2, 1, 3),
            listOf(2, 3, 1), listOf(3, 1, 2), listOf(3, 2, 1))
        assertEquals(expected.sortedBy { it.toString() },
            sol.permuteUnique(array).sortedBy { it.toString() })
    }

    @Test
    fun testExample2() {
        val sol = PermutationsII()
        val array = intArrayOf(1, 1, 2)
        val expected = listOf(listOf(1, 1, 2), listOf(1, 2, 1), listOf(2, 1, 1))
        assertEquals(expected.sortedBy { it.toString() },
            sol.permuteUnique(array).sortedBy { it.toString() })
    }
}