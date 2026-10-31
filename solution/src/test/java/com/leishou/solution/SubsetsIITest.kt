package com.leishou.solution

import org.junit.Test
import kotlin.test.assertEquals

class SubsetsIITest {
    @Test
    fun testExample1() {
        val sol = SubsetsII()
        val array = intArrayOf(1, 2, 2)
        val expected = listOf(listOf(), listOf(1), listOf(2), listOf(1, 2), listOf(1, 2, 2), listOf(2, 2))
        assertEquals(expected.map { it.sorted() }.sortedBy { it.toString() },
            sol.subsetsWithDup(array).map { it.sorted() }.sortedBy { it.toString() })
    }

    @Test
    fun testExample2() {
        val sol = SubsetsII()
        val array = intArrayOf(0)
        val expected = listOf(listOf(), listOf(0))
        assertEquals(expected.map { it.sorted() }.sortedBy { it.toString() },
            sol.subsetsWithDup(array).map { it.sorted() }.sortedBy { it.toString() })
    }

    @Test
    fun testExample3() {
        val sol = SubsetsII()
        val array = intArrayOf(1, 1)
        val expected = listOf(listOf(), listOf(1), listOf(1, 1))
        assertEquals(expected.map { it.sorted() }.sortedBy { it.toString() },
            sol.subsetsWithDup(array).map { it.sorted() }.sortedBy { it.toString() })
    }
}