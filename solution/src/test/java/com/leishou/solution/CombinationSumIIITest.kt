package com.leishou.solution

import org.junit.Test
import kotlin.test.assertEquals

class CombinationSumIIITest {
    @Test
    fun testExample1() {
        val sol = CombinationSumIII()
        val result = sol.combinationSum3(3, 7)
        val sortedActual = result.map { it.sorted() }.sortedBy { it.toString() }
        val sortedExpected = listOf(listOf(1, 2, 4))
            .map { it.sorted() }
            .sortedBy { it.toString() }
        assertEquals(sortedExpected, sortedActual)
    }

    @Test
    fun testExample2() {
        val sol = CombinationSumIII()
        val result = sol.combinationSum3(3, 9)
        val sortedActual = result.map { it.sorted() }.sortedBy { it.toString() }
        val sortedExpected = listOf(listOf(1, 2, 6), listOf(1, 3, 5), listOf(2, 3, 4))
            .map { it.sorted() }
            .sortedBy { it.toString() }
        assertEquals(sortedExpected, sortedActual)
    }

    @Test
    fun testExample3() {
        val sol = CombinationSumIII()
        val result = sol.combinationSum3(4, 1)
        assertEquals(emptyList(), result)
    }
}