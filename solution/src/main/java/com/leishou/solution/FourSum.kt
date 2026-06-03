package com.leishou.solution

class FourSum {
    fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
        val size = nums.size
        if (size < 4)
            return emptyList()

        nums.sort()
        val targetL = target.toLong()
        val ret = mutableListOf<List<Int>>()
        for (i in 0 until size - 3) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue
            }

            var sumMin = nums[i].toLong() + nums[i + 1].toLong() + nums[i + 2].toLong() + nums[i + 3].toLong()
            if (sumMin > targetL)
                break

            var sumMax = nums[i].toLong() + nums[size - 3].toLong() + nums[size - 2].toLong() + nums[size - 1].toLong()
            if (sumMax < targetL)
                continue

            for (j in i + 1 until size - 2) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue
                }

                val sumTwo = nums[i].toLong() + nums[j].toLong()
                sumMin = sumTwo + nums[j + 1].toLong() + nums[j + 2].toLong()
                if (sumMin > targetL)
                    break

                sumMax = sumTwo + nums[size - 2].toLong() + nums[size -1].toLong()
                if (sumMax < targetL)
                    continue

                var left = j + 1
                var right = size - 1
                while (left < right) {
                    val sum = nums[i].toLong() + nums[j].toLong() + nums[left].toLong() + nums[right].toLong()
                    if (sum < targetL) {
                        while (left < right && nums[left] == nums[left + 1]) left++
                        left++
                    } else if (sum > targetL) {
                        while (left < right && nums[right] == nums[right - 1]) right--
                        right--
                    } else {
                        ret.add(listOf(nums[i], nums[j], nums[left], nums[right]))
                        while (left < right && nums[left] == nums[left + 1]) left++
                        while (left < right && nums[right] == nums[right - 1]) right--
                        left++
                        right--
                    }
                }
            }
        }

        return ret
    }
}