package com.leishou.solution

import org.junit.Test
import kotlin.test.assertEquals

class LongestConsecutiveSequenceTest {
    @Test
    fun testExample1() {
        assertEquals(4, LongestConsecutiveSequence().longestConsecutive(intArrayOf(100, 4, 200, 1, 3, 2)))
    }

    @Test
    fun testExample2() {
        val array = intArrayOf(0, 3, 7, 2, 5, 8, 4, 6, 0, 1)
        assertEquals(9, LongestConsecutiveSequence().longestConsecutive(array))
    }

    @Test
    fun testExample3() {
        assertEquals(3, LongestConsecutiveSequence().longestConsecutive(intArrayOf(1, 0, 1, 2)))
    }
}