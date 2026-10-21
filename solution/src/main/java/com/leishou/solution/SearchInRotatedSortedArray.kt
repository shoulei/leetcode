package com.leishou.solution

/*
    There is an integer array nums sorted in ascending order (with distinct values).

    Prior to being passed to your function, nums is possibly left rotated at an unknown index k
    (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1],
    nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be left
    rotated by 3 indices and become [4,5,6,7,0,1,2].

    Given the array nums after the possible rotation and an integer target, return the index of
    target if it is in nums, or -1 if it is not in nums.

    You must write an algorithm with O(log n) runtime complexity.

    1 <= nums.length <= 5000
    -10^4 <= nums[i] <= 10^4
    All values of nums are unique.
    nums is an ascending array that is possibly rotated.
    -10^4 <= target <= 10^4
 */
class SearchInRotatedSortedArray {
    fun search(nums: IntArray, target: Int): Int {
        if (nums.isEmpty())
            return -1

        val n = nums.size
        var left = 0
        var right = n - 1
        while (left <= right) {
            val mid = (left + right) shr 1
            if (target == nums[mid])
                return mid
            if (target == nums[left])
                return left
            if (target == nums[right])
                return right

            if (nums[left] < nums[mid]) { // left -> mid part is sorted, also include ascending array
                if (target > nums[left] && target < nums[mid]) {
                    right = mid - 1
                } else {
                    left = mid + 1
                }
            } else { // mid -> right part is sorted
                if (target > nums[mid] && target < nums[right]) {
                    left = mid + 1
                } else {
                    right = mid - 1
                }
            }
        }

        return -1
    }
}