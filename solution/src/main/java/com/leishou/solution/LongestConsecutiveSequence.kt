package com.leishou.solution

/*
    Given an unsorted array of integers nums, return the length of the longest consecutive elements
    sequence.
    You must write an algorithm that runs in O(n) time.

    0 <= nums.length <= 10^5
    -10^9 <= nums[i] <= 10^9
 */
class LongestConsecutiveSequence {
    fun longestConsecutive(nums: IntArray): Int {
        val n = nums.size
        if (n <= 1)
            return n

        val map = HashMap<Int, Int>() // <current, Length>
        var longest = 1
        for (num in nums) {
            if (map.contains(num))
                continue // handled, ignore

            val before = map[num - 1]?: 0
            val after = map[num + 1]?: 0
            val length = before + after + 1
            val left = num - before // num - 1 - before + 1
            val right = num + after // num + 1 + after - 1
            map[left] = length
            map[right] = length
            map[num] = length
            longest = maxOf(longest, length)
        }

        return longest
    }
}