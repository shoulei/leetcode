package com.leishou.solution

import org.junit.Test
import kotlin.test.assertEquals

class SetMatrixZeroesTest {
    @Test
    fun testExample1() {
        val array = arrayOf(intArrayOf(1, 1, 1), intArrayOf(1, 0, 1), intArrayOf(1, 1, 1))
        SetMatrixZeroes().setZeroes(array)
        val expected = arrayOf(intArrayOf(1, 0, 1), intArrayOf(0, 0, 0), intArrayOf(1, 0 ,1))
        assertEquals(expected.map{ it.toList() }.toList(), array.map{ it.toList() }.toList())
    }

    @Test
    fun testExample2() {
        val array = arrayOf(intArrayOf(0, 1, 2, 0), intArrayOf(3, 4, 5, 2), intArrayOf(1, 3, 1, 5))
        SetMatrixZeroes().setZeroes(array)
        val expected = arrayOf(intArrayOf(0, 0, 0, 0), intArrayOf(0, 4, 5, 0), intArrayOf(0, 3, 1, 0))
        assertEquals(expected.map{ it.toList() }.toList(), array.map{ it.toList() }.toList())
    }

    @Test
    fun testExample3() {
        val array = arrayOf(intArrayOf(1, 0))
        SetMatrixZeroes().setZeroes(array)
        val expected = arrayOf(intArrayOf(0, 0))
        assertEquals(expected.map{ it.toList() }.toList(), array.map{ it.toList() }.toList())
    }

    @Test
    fun testExample4() {
        val array = arrayOf(intArrayOf(1, 0, 3))
        SetMatrixZeroes().setZeroes(array)
        val expected = arrayOf(intArrayOf(0, 0, 0))
        assertEquals(expected.map{ it.toList() }.toList(), array.map{ it.toList() }.toList())
    }
}