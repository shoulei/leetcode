package com.leishou.solution

import org.junit.Test
import kotlin.test.assertEquals

class TriangleTest {
    @Test
    fun testExample1() {
        val sol = Triangle()
        val list = listOf(listOf(-1), listOf(2, 3), listOf(1, -1, -3))
        assertEquals(sol.minimumTotal(list), -1)
    }

    @Test
    fun testExample2() {
        val sol = Triangle()
        val list = listOf(listOf(2), listOf(3, 4), listOf(6, 5, 7), listOf(4, 1, 8, 3))
        assertEquals(sol.minimumTotal(list), 11)
    }
}