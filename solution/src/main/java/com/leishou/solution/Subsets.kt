package com.leishou.solution

/*
    Given an integer array nums of unique elements, return all possible subsets (the power set).
    The solution set must not contain duplicate subsets. Return the solution in any order.

    1 <= nums.length <= 10
    -10 <= nums[i] <= 10
    All the numbers of nums are unique.
 */
class Subsets {
    fun subsets(nums: IntArray): List<List<Int>> {
        val n = nums.size
        val result = mutableListOf<List<Int>>()
        val singlePath = mutableListOf<Int>()

        fun dfs(index: Int) {
            if (index == n) {
                result.add(singlePath.toList())
                return
            }

            singlePath.add(nums[index])
            dfs(index + 1)
            singlePath.removeLast()
            dfs(index + 1)
        }

        dfs(0)
        return result
    }
}