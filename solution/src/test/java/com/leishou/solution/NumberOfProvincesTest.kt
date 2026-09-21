package com.leishou.solution

import org.junit.Test
import kotlin.test.assertEquals

class NumberOfProvincesTest {
    @Test
    fun testExample1() {
        val sol = NumberOfProvinces()
        assertEquals(2, sol.findCircleNum(arrayOf(intArrayOf(1, 1, 0), intArrayOf(1, 1, 0), intArrayOf(0, 0, 1))))
    }

    @Test
    fun testExample2() {
        val sol = NumberOfProvinces()
        assertEquals(3, sol.findCircleNum(arrayOf(intArrayOf(1, 0, 0), intArrayOf(0, 1, 0), intArrayOf(0, 0, 1))))
    }

    @Test
    fun testExample3() {
        val sol = NumberOfProvinces()
        assertEquals(1, sol.findCircleNum(arrayOf(intArrayOf(1, 0, 0, 1),
            intArrayOf(0, 1, 1, 0), intArrayOf(0, 1, 1, 1), intArrayOf(1, 0, 1, 1))))
    }
}