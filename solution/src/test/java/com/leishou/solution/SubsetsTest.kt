package com.leishou.solution

import org.junit.Test
import kotlin.test.assertEquals

class SubsetsTest {
    @Test
    fun testExample1() {
        val sol = Subsets()
        val array = intArrayOf(1, 2, 3)
        val expected = listOf(listOf(), listOf(1), listOf(2),
            listOf(3), listOf(1, 2), listOf(1, 3), listOf(2, 3), listOf(1, 2 ,3))
        assertEquals(expected.map { it.sorted() }.sortedBy { it.toString() },
            sol.subsets(array).map { it.sorted() }.sortedBy { it.toString() })
    }

    @Test
    fun testExample2() {
        val sol = Subsets()
        val array = intArrayOf(0)
        val expected = listOf(listOf(), listOf(0))
        assertEquals(expected.map { it.sorted() }.sortedBy { it.toString() },
            sol.subsets(array).map { it.sorted() }.sortedBy { it.toString() })
    }
}