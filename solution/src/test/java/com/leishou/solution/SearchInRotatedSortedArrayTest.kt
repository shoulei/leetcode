package com.leishou.solution

import org.junit.Test
import kotlin.test.assertEquals

class SearchInRotatedSortedArrayTest {
    @Test
    fun testExample1() {
        val sol = SearchInRotatedSortedArray()
        assertEquals(4, sol.search(intArrayOf(4, 5, 6, 7, 0, 1, 2), 0))
    }

    @Test
    fun testExample2() {
        val sol = SearchInRotatedSortedArray()
        assertEquals(-1, sol.search(intArrayOf(4, 5, 6, 7, 0, 1, 2), 3))
    }

    @Test
    fun testExample3() {
        val sol = SearchInRotatedSortedArray()
        assertEquals(-1, sol.search(intArrayOf(1), 0))
    }

    @Test
    fun testExample4() {
        val sol = SearchInRotatedSortedArray()
        assertEquals(0, sol.search(intArrayOf(1), 1))
    }

    @Test
    fun testExample5() {
        val sol = SearchInRotatedSortedArray()
        assertEquals(-1, sol.search(intArrayOf(1, 3, 5), 2))
    }

    @Test
    fun testExample6() {
        val sol = SearchInRotatedSortedArray()
        assertEquals(1, sol.search(intArrayOf(1, 3), 3))
    }
}