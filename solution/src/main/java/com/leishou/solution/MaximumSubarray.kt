package com.leishou.solution

class MaximumSubArray {
    fun maxSubArray(nums: IntArray): Int {
        var sum = 0
        var maxSum = Int.MIN_VALUE
        for (i in nums.indices) {
            sum = maxOf(nums[i], sum + nums[i])
            maxSum = maxOf(maxSum, sum)
        }

        return maxSum
    }
}