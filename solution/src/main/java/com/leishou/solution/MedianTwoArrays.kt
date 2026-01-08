package com.leishou.solution

class MedianTwoArrays {
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        val n = nums1.size
        val m = nums2.size
        var i = 0
        var j = 0
        val mid0: Int = (n + m) / 2
        val mid1: Int = if ((m + n) % 2 == 0)  mid0 - 1 else mid0
        val top = mid0 + 1
        var v0 = 0
        var v1 = 0
        for (index in 0 until top) {
            val v: Int = when {
                i < n -> {
                    if (j < m) {
                        if (nums1[i] < nums2[j]) {
                            nums1[i++]
                        } else {
                            nums2[j++]
                        }
                    } else {
                        nums1[i++]
                    }
                }
                else -> {
                    if (j < m) {
                        nums2[j++]
                    } else {
                        throw Exception("Invalid branch")
                    }
                }
            }

            if (index == mid0) v0 = v
            if (index == mid1) v1 = v
        }

        return (v0 + v1) / 2.0
    }
}