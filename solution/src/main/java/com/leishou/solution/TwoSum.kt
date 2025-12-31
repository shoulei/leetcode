package com.leishou.solution

class TwoSum {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = mutableMapOf<Int, Int>()
        nums.forEachIndexed { index, i ->
            val diff = target - i
            if (map.contains(diff) && map[diff] != index) {
                return intArrayOf(index, map[diff]!!)
            } else {
                map[i] = index
            }
        }

        return intArrayOf()
    }
}