package com.leishou.solution

/*
    You are given a 0-indexed array of integers nums of length n. You are initially positioned at
    index 0.

    Each element nums[i] represents the maximum length of a forward jump from index i. In other
    words, if you are at index i, you can jump to any index (i + j) where:

    0 <= j <= nums[i] and
    i + j < n
    Return the minimum number of jumps to reach index n - 1. The test cases are generated such that
    you can reach index n - 1.

    1 <= nums.length <= 10^4
    0 <= nums[i] <= 1000
    It's guaranteed that you can reach nums[n - 1].
 */
class JumpGameII {
    fun jump(nums: IntArray): Int {
        val n = nums.size
        if (n == 1)
            return 0

        var steps = 0
        var left = 0
        var right = 0
        var furthest = 0
        while (right < n - 1) {
            for (i in left..right) {
                furthest = maxOf(furthest, nums[i] + i)
            }
            left = right + 1
            right = furthest
            steps++
        }

        return steps
    }
}