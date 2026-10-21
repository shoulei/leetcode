package com.leishou.solution

import org.junit.Test
import kotlin.test.assertContentEquals

class FindFirstAndLastPositionTest {
    @Test
    fun testExample1() {
        val array = intArrayOf(5, 7, 7, 8, 8, 10)
        assertContentEquals(intArrayOf(3, 4), FindFirstAndLastPosition().searchRange(array, 8))
    }

    @Test
    fun testExample2() {
        val array = intArrayOf(5, 7, 7, 8, 8, 10)
        assertContentEquals(intArrayOf(-1, -1), FindFirstAndLastPosition().searchRange(array, 6))
    }

    @Test
    fun testExample3() {
        val array = intArrayOf()
        assertContentEquals(intArrayOf(-1, -1), FindFirstAndLastPosition().searchRange(array, 0))
    }

    @Test
    fun testExample4() {
        val array = intArrayOf(2, 2)
        assertContentEquals(intArrayOf(0, 1), FindFirstAndLastPosition().searchRange(array, 2))
    }
}