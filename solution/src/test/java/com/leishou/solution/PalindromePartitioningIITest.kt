package com.leishou.solution

import org.junit.Test
import kotlin.test.assertEquals

class PalindromePartitioningIITest {
    @Test
    fun testExample1() {
        assertEquals(1, PalindromePartitioningII().minCut("aab"))
    }

    @Test
    fun testExample2() {
        assertEquals(0, PalindromePartitioningII().minCut("a"))
    }

    @Test
    fun testExample3() {
        assertEquals(1, PalindromePartitioningII().minCut("ab"))
    }

    @Test
    fun testExample4() {
        assertEquals(3, PalindromePartitioningII().minCut("ccaacabacb"))
    }
}