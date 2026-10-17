package com.leishou.solution

/*
    Given an array of integers nums and an integer k, return the total number of subarrays
    whose sum equals to k.
    A subarray is a contiguous non-empty sequence of elements within an array.

    1 <= nums.length <= 2 * 10^4
    -1000 <= nums[i] <= 1000
    -10^7 <= k <= 10^7
 */
class SubarraySumEqualsK {
    fun subarraySum(nums: IntArray, k: Int): Int {
        val n = nums.size
        var sum = 0
        val map = HashMap<Int, Int>()
        map[0] = 1
        var subArrayCt = 0
        for (i in 0 until n) {
            sum += nums[i]
            // sum(i, j) = sum(0, j) - sum(0, i - 1)
            // which means if we need sum(i, j) = k, there should be a sum-k already
            val diff = sum - k
            subArrayCt += map.getOrDefault(diff, 0)
            map[sum] = map.getOrDefault(sum, 0) + 1
        }

        return subArrayCt
    }

    fun subarraySum_(nums: IntArray, k: Int): Int {
        val n = nums.size
        // memo[i][j] means sum from nums[i]..nums[j]
        // Memory Limit Exceeded Warning here
        //val memo = Array(n) {
        //    IntArray(n)
        //}
        // prefixMemo[i] means sum from 0..i
        val prefixMemo = IntArray(n)
        // suffixMemo[i] means sum from i..n-1
        val suffixMemo = IntArray(n)

        var subArrayCt = 0
        var sum = 0
        for (i in 0 until n) {
            sum += nums[i]
            prefixMemo[i] = sum
            if (sum == k) {
                subArrayCt++
            }
        }

        sum = 0
        for (i in n - 1 downTo 1) {
            sum += nums[i]
            suffixMemo[i] = sum
            if (sum == k) {
                subArrayCt++
            }
        }

        for (i in 1 until n - 1) {
            for (j in i until n - 1) {
                val sumIJ = prefixMemo[j] + suffixMemo[i] - prefixMemo[n - 1]
                if (sumIJ == k) {
                    subArrayCt++
                }
            }
        }

        return subArrayCt
    }
}