package com.leishou.solution

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