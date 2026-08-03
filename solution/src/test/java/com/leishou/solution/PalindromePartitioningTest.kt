package com.leishou.solution

import org.junit.Test
import kotlin.test.assertContentEquals

class PalindromePartitioningTest {
    @Test
    fun testExample1() {
        val sol = PalindromePartitioning()
        val ret = sol.partition("aab")
        assertContentEquals(listOf(listOf("a", "a", "b"), listOf("aa", "b")), ret)
    }
}