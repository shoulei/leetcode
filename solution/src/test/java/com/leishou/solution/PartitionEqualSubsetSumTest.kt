package com.leishou.solution

import org.junit.Test
import kotlin.test.assertEquals

class PartitionEqualSubsetSumTest {
    @Test
    fun testExample1() {
        assertEquals(true, PartitionEqualSubsetSum().canPartition(intArrayOf(1, 5, 11, 5)))
    }

    @Test
    fun testExample2() {
        assertEquals(false, PartitionEqualSubsetSum().canPartition(intArrayOf(1, 2, 3, 5)))
    }

    @Test
    fun testExample3() {
        assertEquals(true, PartitionEqualSubsetSum().canPartition(intArrayOf(1, 2, 3, 35, 19, 20)))
    }
}