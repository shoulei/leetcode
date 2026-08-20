package com.leishou.solution

class FirstMissingPositive {
    fun firstMissingPositive(nums: IntArray): Int {
        val n = nums.size
        fun swap(i: Int, j: Int) {
            if (i == j)
                return
            val temp = nums[i]
            nums[i] = nums[j]
            nums[j] = temp
        }

        for (i in nums.indices) {
            while (nums[i] in 1 until n && nums[nums[i] - 1] != nums[i]) {
                swap(nums[i] - 1, i)
            }
        }

        for (i in nums.indices) {
            if (nums[i] != i + 1)
                return i + 1
        }

        return n + 1
    }
}