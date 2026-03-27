package com.leishou.solution

class SlideWindow {
    fun getMaxNumbersArray(nums: IntArray, k: Int): IntArray {
        val ordersNum = ArrayDeque<Int>()
        val list = IntArray(nums.size - k + 1)

        for (i in nums.indices) {
            if (ordersNum.isNotEmpty() && ordersNum.first() <= i - k) {
                ordersNum.removeFirst()
            }

            while (ordersNum.isNotEmpty() && nums[ordersNum.last()] < nums[i]) {
                ordersNum.removeLast()
            }

            ordersNum.addLast(i)

            val index = i - k + 1
            if (index >= 0) {
                list[index] = nums[ordersNum.first()]
            }
        }

        return list
    }
}