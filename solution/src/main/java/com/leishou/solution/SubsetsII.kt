package com.leishou.solution

/*
    Given an integer array nums that may contain duplicates, return all possible subsets (the power
    set).
    The solution set must not contain duplicate subsets. Return the solution in any order.

    1 <= nums.length <= 10
    -10 <= nums[i] <= 10
 */
class SubsetsII {
    fun subsetsWithDup(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        val n = nums.size

        nums.sort()
        val path = mutableListOf<Int>()
        val used = BooleanArray(n) { false }
        fun dfs(index: Int) {
            if (index == n) {
                result.add(path.toList())
                return
            }

            // choose
            if (index == 0 || nums[index - 1] != nums[index] || used[index - 1]) {
                path.add(nums[index])
                used[index] = true
                dfs(index + 1)
                used[index] = false
                path.removeLast()
            }

            // skip
            dfs(index + 1)
        }

        dfs(0)
        return result
    }
}