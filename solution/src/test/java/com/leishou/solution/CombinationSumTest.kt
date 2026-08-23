package com.leishou.solution

import org.junit.Test
import kotlin.test.assertContentEquals

class CombinationSumTest {
    @Test
    fun testExample1() {
        val sol = CombinationSum()
        assertContentEquals(emptyList(), sol.combinationSum(intArrayOf(2), 1))
    }

    @Test
    fun testExample2() {
        val sol = CombinationSum()
        val expected = listOf(listOf(2, 2, 2, 2), listOf(2, 3, 3), listOf(3, 5))
            .map { it.sorted() }
            .sortedBy { it.toString() }
        val ret = sol.combinationSum(intArrayOf(2, 3, 5), 8)
            .map { it.sorted() }
            .sortedBy { it.toString() }
        assertContentEquals(expected, ret)
    }

    @Test
    fun testExample3() {
        val sol = CombinationSum()
        val expected = listOf(listOf(2, 2, 3), listOf(7))
            .map { it.sorted() }
            .sortedBy { it.toString() }
        val ret = sol.combinationSum(intArrayOf(2, 3, 6, 7), 7)
            .map { it.sorted() }
            .sortedBy { it.toString() }
        assertContentEquals(expected, ret)
    }
}