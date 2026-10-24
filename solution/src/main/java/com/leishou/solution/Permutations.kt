package com.leishou.solution

/*
    Given an array nums of distinct integers, return all the possible permutations. You can return
    the answer in any order.

    1 <= nums.length <= 6
    -10 <= nums[i] <= 10
    All the integers of nums are unique.
 */
class Permutations {
    fun permute(nums: IntArray): List<List<Int>> {
        val n = nums.size
        var result = listOf(listOf(nums[0]))
        var index = 1
        repeat(n - 1) {
            val newList = ArrayList<List<Int>>(index * (index + 1))
            for (list in result) {
                for (i in 0..index) {
                    val l = list.toMutableList()
                    l.add(i, nums[index])
                    newList.add(l)
                }
            }

            result = newList
            index++
        }

        return result
    }
}