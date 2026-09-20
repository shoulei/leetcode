package com.leishou.solution

/*
    You are given n balloons, indexed from 0 to n - 1. Each balloon is painted with a number on it
    represented by an array nums. You are asked to burst all the balloons.
    If you burst the ith balloon, you will get nums[i - 1] * nums[i] * nums[i + 1] coins.
    If i - 1 or i + 1 goes out of bounds of the array, then treat it as if there is a balloon with
    a 1 painted on it.

    Return the maximum coins you can collect by bursting the balloons wisely.
 */
class BurstBalloons {
    fun maxCoins(nums: IntArray): Int {
        val size = nums.size
        val dp = Array(size) {
            IntArray(size) { -1 }
        }

        fun dfs(left: Int, right: Int): Int {
            if (left > right)
                return 0

            if (dp[left][right] >= 0)
                return dp[left][right]

            val previous = if ((left - 1) >= 0) nums[left - 1] else 1
            val next = if ((right + 1) >= size) 1 else nums[right + 1]
            var max = 0
            for (i in left until right + 1) {
                max = maxOf(max, dfs(left, i - 1) + dfs(i + 1, right) + nums[i] * previous * next)
            }

            dp[left][right] = max
            return max
        }

        return dfs(0, size - 1)
    }
}