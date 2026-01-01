package com.leishou.solution

class TwoSum {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = HashMap<Int, Int>(nums.size)
        for (i in nums.indices) {
            val diff = target - nums[i]
            val j = map[diff]
            if (j != null) {
                return intArrayOf(j, i)
            } else {
                map[nums[i]] = i
            }
        }

        return intArrayOf()
    }
}