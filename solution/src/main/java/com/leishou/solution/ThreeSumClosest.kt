package com.leishou.solution

import kotlin.math.abs

class ThreeSumClosest {
    fun threeSumClosest(nums: IntArray, target: Int): Int {
        require(nums.size >= 3)
        nums.sort()
        val size = nums.size
        var closest = nums[0] + nums[1] + nums[2]
        var minGap = abs(target - closest)
        for (i in 0 until size - 2) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue
            }

            val rest = target - nums[i]
            var left = i + 1
            var right = size - 1
            while (left < right) {
                val sum = nums[left] + nums[right]
                val gap = abs(rest - sum)
                if (gap == 0) {
                    return target
                }

                if (gap <= minGap) {
                    minGap = gap
                    closest = sum + nums[i]
                }

                if (sum < rest) {
                    while (nums[left] == nums[left + 1] && left + 1 < right) left++
                    left++
                } else {
                    while (nums[right] == nums[right - 1] && right - 1 > left) right--
                    right--
                }
            }
        }

        return closest
    }
}