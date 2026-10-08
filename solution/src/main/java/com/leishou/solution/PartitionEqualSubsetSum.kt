package com.leishou.solution

/*
    Given an integer array nums, return true if you can partition the array into two subsets
    such that the sum of the elements in both subsets is equal or false otherwise.

    1 <= nums.length <= 200
    1 <= nums[i] <= 100
 */
class PartitionEqualSubsetSum {
    fun canPartition(nums: IntArray): Boolean {
        val sum = nums.sum()
        if (sum and 1 == 1)
            return false

        val half = sum shr 1
        val dp = BooleanArray(half + 1)
        dp[0] = true
        for (num in nums) {
            for (j in half downTo num) {
                dp[j] = dp[j] || dp[j - num]
            }

            if (dp[half])
                return true
        }

        return false
    }

    fun canPartition_(nums: IntArray): Boolean {
        val n = nums.size
        val sum = nums.sum()
        if (sum % 2 != 0)
            return false

        val half = sum shr 1
        val memo = Array(n) {
            IntArray(half + 1) { -1 } // -1: uninitialized, 0: false, 1: true
        }
        fun dfs(index: Int, remain: Int): Boolean {
            if (remain == 0) {
                return true
            } else if (index == n) {
                return false
            }

            if (memo[index][remain] != -1) {
                return memo[index][remain] > 0
            }

            val ret = if (remain >= nums[index]) {
                dfs(index + 1, remain) || dfs(index + 1, remain - nums[index])
            } else {
                dfs(index + 1, remain)
            }

            memo[index][remain] = if (ret) 1 else 0
            return ret
        }

        return dfs(0, half)
    }
}