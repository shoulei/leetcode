package com.leishou.solution

import org.junit.Test
import kotlin.test.assertContentEquals

class TopKFrequentElementsTest {
    @Test
    fun testExample1() {
        assertContentEquals(intArrayOf(1, 2),
            TopKFrequentElements().topKFrequent(intArrayOf(1, 1, 1, 2, 2, 3), 2))
    }

    @Test
    fun testExample2() {
        assertContentEquals(intArrayOf(1),
            TopKFrequentElements().topKFrequent(intArrayOf(1), 1))
    }

    @Test
    fun testExample3() {
        assertContentEquals(intArrayOf(1, 2),
            TopKFrequentElements().topKFrequent(intArrayOf(1, 2, 1, 2, 1, 2, 3, 1, 3, 2), 2))
    }
}