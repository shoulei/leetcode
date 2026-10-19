package com.leishou.solution

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