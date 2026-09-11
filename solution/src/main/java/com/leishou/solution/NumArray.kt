package com.leishou.solution

class NumArray(nums: IntArray)  {
    private val sumArray = IntArray(nums.size)
    init {
        var ret = 0
        for (i in nums.indices) {
            ret += nums[i]
            sumArray[i] = ret
        }
    }

    fun sumRange(left: Int, right: Int): Int {
        return sumArray[right] - if (left >= 1) sumArray[left - 1] else 0
    }
}