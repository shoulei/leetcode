package com.leishou.solution

import org.junit.Test
import kotlin.test.assertEquals

class PermutationsTest {
    @Test
    fun testExample1() {
        val sol = Permutations()
        val array = intArrayOf(1, 2, 3)
        val expected = listOf(listOf(1, 2, 3), listOf(1, 3, 2), listOf(2, 1, 3),
            listOf(2, 3, 1), listOf(3, 1, 2), listOf(3, 2, 1))
        assertEquals(expected.sortedBy { it.toString() },
            sol.permute(array).sortedBy { it.toString() })
    }

    @Test
    fun testExample2() {
        val sol = Permutations()
        val array = intArrayOf(0, 1)
        val expected = listOf(listOf(0, 1), listOf(1, 0))
        assertEquals(expected.sortedBy { it.toString() },
            sol.permute(array).sortedBy { it.toString() })
    }

    @Test
    fun testExample3() {
        val sol = Permutations()
        val array = intArrayOf(1)
        val expected = listOf(listOf(1))
        assertEquals(expected.sortedBy { it.toString() },
            sol.permute(array).sortedBy { it.toString() })
    }
}