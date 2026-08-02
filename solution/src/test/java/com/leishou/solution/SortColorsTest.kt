package com.leishou.solution

import org.junit.Test
import kotlin.test.assertContentEquals

class SortColorsTest {
    @Test
    fun testExample1() {
        val sol = SortColors()
        val array = intArrayOf(2, 0, 2, 1, 1, 0)
        sol.sortColors(array)
        assertContentEquals(intArrayOf(0, 0, 1, 1, 2, 2), array)
    }

    @Test
    fun testExample2() {
        val sol = SortColors()
        val array = intArrayOf(2, 0, 1)
        sol.sortColors(array)
        assertContentEquals(intArrayOf(0, 1, 2), array)
    }

    @Test
    fun testExample3() {
        val sol = SortColors()
        val array = intArrayOf(1, 2, 0)
        sol.sortColors(array)
        assertContentEquals(intArrayOf(0, 1, 2), array)
    }

    @Test
    fun testExample4() {
        val sol = SortColors()
        val array = intArrayOf(2, 1, 2)
        sol.sortColors(array)
        assertContentEquals(intArrayOf(1, 2, 2), array)
    }
}