package com.leishou.solution

/*
    You are given an integer array nums. You are initially positioned at the array's first index,
    and each element in the array represents your maximum jump length at that position.

    Return true if you can reach the last index, or false otherwise.
 */
class JumpGame {
    fun canJump(nums: IntArray): Boolean {
        val size = nums.size
        var maxReach = 0
        for (i in 0 until size) {
            if (i > maxReach) {
                return false
            }

            maxReach = maxOf(maxReach, i + nums[i])
            if (maxReach >= size - 1) {
                return true
            }
        }

        return true
    }
}