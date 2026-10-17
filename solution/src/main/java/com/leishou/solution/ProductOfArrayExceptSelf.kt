package com.leishou.solution

/*
    Given an integer array nums, return an array answer such that answer[i] is equal to the
    product of all the elements of nums except nums[i].

    The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
    You must write an algorithm that runs in O(n) time and without using the division operation.

    2 <= nums.length <= 105
    -30 <= nums[i] <= 30
    The input is generated such that answer[i] is guaranteed to fit in a 32-bit integer.
 */
class ProductOfArrayExceptSelf {
    fun productExceptSelf(nums: IntArray): IntArray {
        val n = nums.size
        val result = IntArray(n)
        var product = 1
        // Prefix, after this, result[i] = product of elements before i
        for (i in 0 until n) {
            result[i] = product
            product *= nums[i]
        }

        // Suffix
        product = 1
        for (i in n - 1 downTo  0) {
            result[i] *= product
            product *= nums[i]
        }

        return result
    }

    // Illegal as using division
    fun productExceptSelf_(nums: IntArray): IntArray {
        val n = nums.size
        var product = 1
        var zeroCt = 0
        for (num in nums) {
            if (num != 0) {
                product *= num
            } else {
                zeroCt++
            }
        }

        if (zeroCt > 1)
            return IntArray(n) { 0 }

        return IntArray(n) {
            if (zeroCt == 1) {
                if (nums[it] == 0) product else 0
            } else {
                product / nums[it] // using division here
            }
        }
    }
}