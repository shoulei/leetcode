package com.leishou.solution

import org.junit.Test
import kotlin.test.assertEquals

/*
    Given two sorted arrays nums1 and nums2 of size m and n respectively
    return the median of the two sorted arrays.
 */
class MediaTwoArraysTest {
    @Test
    fun testExample1() {
        val sol = MedianTwoArrays()
        val result = sol.findMedianSortedArrays(intArrayOf(1, 3), intArrayOf(2))
        assertEquals(2.0, result)
    }

    @Test
    fun testExample2() {
        val sol = MedianTwoArrays()
        val result = sol.findMedianSortedArrays(intArrayOf(1, 3), intArrayOf(2, 4))
        assertEquals(2.5, result)
    }
}