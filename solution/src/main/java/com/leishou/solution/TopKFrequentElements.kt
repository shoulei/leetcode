package com.leishou.solution

import java.util.PriorityQueue

/*
    Given an integer array nums and an integer k, return the k most frequent elements.
    You may return the answer in any order.

    1 <= nums.length <= 105
    -104 <= nums[i] <= 104
    k is in the range [1, the number of unique elements in the array].
    It is guaranteed that the answer is unique.
 */
class TopKFrequentElements {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val n = nums.size
        val map = HashMap<Int, Int>()
        for (num in nums) {
            map[num] = map.getOrDefault(num, 0) + 1
        }

        val bucket = Array(n + 1) {
            mutableListOf<Int>()
        }

        for ((num, frequency) in map) {
            bucket[frequency].add(num)
        }

        val result = IntArray(k)
        var index = 0
        for (i in n downTo 1) {
            for (num in bucket[i]) {
                result[index++] = num
                if (index >= k)
                    return result
            }
        }

        return result
    }

    fun topKFrequent_(nums: IntArray, k: Int): IntArray {
        val map = HashMap<Int, Int>()
        for (n in nums) {
            map[n] = map.getOrDefault(n, 0) + 1
        }

        val heap = PriorityQueue<Map.Entry<Int, Int>>(compareByDescending { it.value })
        heap.addAll(map.entries)
        return IntArray(k) { heap.poll()!!.key }
    }
}