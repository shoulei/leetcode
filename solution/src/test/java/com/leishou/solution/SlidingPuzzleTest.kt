package com.leishou.solution

import org.junit.Test
import kotlin.test.assertEquals

class SlidingPuzzleTest {
    @Test
    fun testExample1() {
        assertEquals(1, SlidingPuzzle().slidingPuzzle(arrayOf(intArrayOf(1, 2, 3), intArrayOf(4, 0 ,5))))
    }

    @Test
    fun testExample2() {
        assertEquals(-1, SlidingPuzzle().slidingPuzzle(arrayOf(intArrayOf(1, 2, 3), intArrayOf(5, 4 ,0))))
    }

    @Test
    fun testExample3() {
        assertEquals(5, SlidingPuzzle().slidingPuzzle(arrayOf(intArrayOf(4, 1, 2), intArrayOf(5, 0 ,3))))
    }
}