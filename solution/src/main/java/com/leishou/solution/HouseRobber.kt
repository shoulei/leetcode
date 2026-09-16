package com.leishou.solution

/*
    You are a professional robber planning to rob houses along a street. Each house has a certain
    amount of money stashed, the only constraint stopping you from robbing each of them is that
    adjacent houses have security systems connected and it will automatically contact the police
    if two adjacent houses were broken into on the same night.
    Given an integer array nums representing the amount of money of each house, return the maximum
    amount of money you can rob tonight without alerting the police.
 */
class HouseRobber {
    fun rob(nums: IntArray): Int {
        var prev2 = 0
        var prev = 0
        for (n in nums) {
            val current = maxOf(prev, prev2 + n)
            prev2 = prev
            prev = current
        }

        return prev
    }

    fun rob_(nums: IntArray): Int {
        val size = nums.size
        val memo = IntArray(size) { -1 }
        fun dfs(n: Int): Int {
            if (n > size - 1)
                return 0

            if (memo[n] != -1)
                return memo[n]

            return maxOf(nums[n] + dfs(n + 2), dfs(n + 1)).also {
                memo[n] = it
            }
        }

        return dfs(0)
    }
}