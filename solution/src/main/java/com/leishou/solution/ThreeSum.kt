package com.leishou.solution

class ThreeSum {
    fun threeSum(nums: IntArray): List<List<Int>> {
        nums.sort()
        val ret = mutableListOf<List<Int>>()
        val size = nums.size
        for (i in 0 until size - 2) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue
            }

            val rest = -nums[i]
            var left = i + 1
            var right = size - 1
            while (left < right) {
                val sum = nums[left] + nums[right]
                val leftValue = nums[left]
                val rightValue = nums[right]
                if (sum == rest) {
                    ret.add(listOf(nums[i], nums[left], nums[right]))
                    while (nums[left] == leftValue && left < right) {
                        left++
                    }

                    while (nums[right] == rightValue && left < right) {
                        right--
                    }
                } else if (sum < rest) {
                    left++
                } else {
                    right--
                }
            }
        }

        return ret
    }
}