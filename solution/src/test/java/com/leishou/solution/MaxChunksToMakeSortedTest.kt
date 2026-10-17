package com.leishou.solution

import org.junit.Test
import kotlin.test.assertEquals

class MaxChunksToMakeSortedTest {
    @Test
    fun testExample1() {
        assertEquals(1, MaxChunksToMakeSorted().maxChunksToSorted(intArrayOf(4, 3, 2, 1, 0)))
    }

    @Test
    fun testExample2() {
        assertEquals(4, MaxChunksToMakeSorted().maxChunksToSorted(intArrayOf(1, 0, 2, 3, 4)))
    }

    @Test
    fun testExample3() {
        assertEquals(1, MaxChunksToMakeSorted().maxChunksToSorted(intArrayOf(2, 0, 1)))
    }

    @Test
    fun testExample4() {
        assertEquals(2, MaxChunksToMakeSorted().maxChunksToSorted(intArrayOf(1, 2, 0, 3)))
    }
}