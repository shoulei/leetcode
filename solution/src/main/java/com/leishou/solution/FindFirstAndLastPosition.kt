package com.leishou.solution

/*
    Given an array of integers nums sorted in non-decreasing order, find the starting and ending
    position of a given target value.

    If target is not found in the array, return [-1, -1].

    You must write an algorithm with O(log n) runtime complexity.

    0 <= nums.length <= 10^5
    -10^9 <= nums[i] <= 10^9
    nums is a non-decreasing array.
    -10^9 <= target <= 10^9
 */
class FindFirstAndLastPosition {
    fun searchRange(nums: IntArray, target: Int): IntArray {
        if (nums.isEmpty())
            return intArrayOf(-1, -1)

        val n = nums.size
        var left = 0
        var right = n - 1
        while (left <= right) {
            val mid = (left + right) shr 1
            if (nums[mid] < target) {
                left = mid + 1
            } else if (nums[mid] > target) {
                right = mid - 1
            } else {
                // left boundary
                var leftHalfRight = mid
                while (left < leftHalfRight) {
                    // floor
                    val leftMid = (left + leftHalfRight) shr 1
                    if (nums[leftMid] != target) {
                        left = leftMid + 1
                    } else {
                        leftHalfRight = leftMid
                    }
                }

                // right boundary
                var rightHalfLeft = mid
                while (rightHalfLeft < right) {
                    // celling
                    val rightMid = (rightHalfLeft + right + 1) shr 1
                    if (nums[rightMid] != target) {
                        right = rightMid - 1
                    } else {
                        rightHalfLeft = rightMid
                    }
                }

                return intArrayOf(leftHalfRight, rightHalfLeft)
            }
        }

        return intArrayOf(-1, -1)
    }
}