package com.leishou.solution

import kotlin.math.min

/*
    A permutation of an array of integers is an arrangement of its members into a sequence or linear
    order.
    For example, for arr = [1,2,3], the following are all the permutations of arr: [1,2,3], [1,3,2],
    [2, 1, 3], [2, 3, 1], [3,1,2], [3,2,1].
    The next permutation of an array of integers is the next lexicographically greater permutation
    of its integer. More formally, if all the permutations of the array are sorted in one container
    according to their lexicographical order, then the next permutation of that array is the
    permutation that follows it in the sorted container. If such arrangement is not possible,
    the array must be rearranged as the lowest possible order (i.e., sorted in ascending order).

    For example, the next permutation of arr = [1,2,3] is [1,3,2].
    Similarly, the next permutation of arr = [2,3,1] is [3,1,2].
    While the next permutation of arr = [3,2,1] is [1,2,3] because [3,2,1] does not have a
    lexicographical larger rearrangement.
    Given an array of integers nums, find the next permutation of nums.

    The replacement must be in place and use only constant extra memory.

    1 <= nums.length <= 100
    0 <= nums[i] <= 100
 */
class NextPermutation {
    fun nextPermutation(nums: IntArray) {
        // 0, find the rightest ascending pair then handle all nums after lastAscendingIndex
        // (lastAscendingIndex inclusive)
        // 1, smallest but larger than nums[lastAscendingIndex] put the 1st, as it keeps descending
        // since lastIndex + 1, that means the rightest num that larger than nums[lastAscendingIndex]
        // 2, swap those two nums, after swap, nums after lastAscendingIndex+1 still keeps descending
        // 3, then from lastAscendingIndex+1 to end, put in a ascending way, which means reverse them

        // Step 0 and 1
        val n = nums.size
        var lastAscendingIndex = -1
        var swapIndex = -1
        for (i in 0 until n) {
            if (i + 1 < n && nums[i] < nums[i + 1]) {
                lastAscendingIndex = i
            }

            if (lastAscendingIndex >= 0 && nums[i] > nums[lastAscendingIndex]) {
                swapIndex = i
            }
        }

        // Step 2: swap
        if (lastAscendingIndex >=0 && swapIndex >= 0) {
            val temp = nums[lastAscendingIndex]
            nums[lastAscendingIndex] = nums[swapIndex]
            nums[swapIndex] = temp
        }

        // step 3: reverse nums after lastAscendingIndex+1
        var left = lastAscendingIndex + 1
        var right = n - 1
        while (left < right) {
            val temp = nums[left]
            nums[left] = nums[right]
            nums[right] = temp
            left++
            right--
        }
    }
}