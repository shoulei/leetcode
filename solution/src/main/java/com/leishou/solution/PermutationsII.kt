package com.leishou.solution

/*
    Given a collection of numbers, nums, that might contain duplicates, return all possible unique
    permutations in any order.

    1 <= nums.length <= 8
    -10 <= nums[i] <= 10
 */
class PermutationsII {
    fun permuteUnique(nums: IntArray): List<List<Int>> {
        val n = nums.size
        nums.sort()
        val used = BooleanArray(n) { false }

        val result = mutableListOf<List<Int>>()
        val path = ArrayList<Int>(n)
        fun dfs() {
            if (path.size == n) {
                result.add(path.toList())
                return
            }

            for (i in nums.indices) {
                if (used[i])
                    continue

                if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])
                    continue

                path.add(nums[i])
                used[i] = true
                dfs()
                path.removeLast()
                used[i] = false
            }
        }

        dfs()
        return result
    }
}