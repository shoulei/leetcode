package com.leishou.solution

import org.junit.Test
import kotlin.test.assertContentEquals

class CombinationSumIITest {
    @Test
    fun testExample1() {
        val sol = CombinationSumII()
        val expected = listOf(listOf(1, 1, 6), listOf(1, 2, 5), listOf(1, 7), listOf(2, 6))
            .map { it.sorted() }
            .sortedBy { it.toString() }
        val ret = sol.combinationSum2(intArrayOf(10, 1, 2, 7, 6, 1, 5), 8)
            .map { it.sorted() }
            .sortedBy { it.toString() }
        assertContentEquals(expected, ret)
    }

    @Test
    fun testExample2() {
        val sol = CombinationSumII()
        val expected = listOf(listOf(1, 2, 2), listOf(5))
            .map { it.sorted() }
            .sortedBy { it.toString() }
        val ret = sol.combinationSum2(intArrayOf(2, 5, 2, 1, 2), 5)
            .map { it.sorted() }
            .sortedBy { it.toString() }
        assertContentEquals(expected, ret)
    }
}