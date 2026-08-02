package com.leishou.solution

class SortColors {
    fun sortColors(nums: IntArray) {
        var low = 0
        var high = nums.size - 1
        var cur = 0
        while (cur < nums.size) {
            when (nums[cur]) {
                0 -> {
                    nums[cur] = nums[low]
                    nums[low] = 0
                    low++
                }

                1 -> {
                    // do nothing
                }

                else -> {
                    nums[cur] = nums[high]
                    nums[high] = 2
                    high--
                    cur--
                }
            }

            cur++
            if (low >= high || cur > high) {
                break
            }
        }
    }
}