package com.leishou.solution

import java.util.PriorityQueue

/*
    Given a circular integer array nums (i.e., the next element of nums[nums.length - 1] is nums[0]),
    return the next greater number for every element in nums.

    The next greater number of a number x is the first greater number to its traversing-order next
    in the array, which means you could search circularly to find its next greater number.
    If it doesn't exist, return -1 for this number.
 */
class NextGreaterElementII {
    fun nextGreaterElements(nums: IntArray): IntArray {
        val size = nums.size
        val indexArray = IntArray(size)
        val ret = IntArray(size) { -1 }
        var pop = -1
        for (i in 0 until size * 2) {
            val current = nums[i % size]
            while (pop >= 0 && nums[indexArray[pop]] < current) {
                ret[indexArray[pop--]] = current
            }

            if (i < size) {
                indexArray[++pop] = i
            }
        }

        return ret
    }

    fun nextGreaterElements0(nums: IntArray): IntArray {
        val stack = ArrayDeque<Int>()
        val size = nums.size
        val ret = IntArray(size) { -1 }
        for (i in 0 until size * 2) {
            val current = nums[i % size]
            while (stack.isNotEmpty() && nums[stack.last()] < current) {
                ret[stack.last()] = current
                stack.removeLast()
            }

            if (i < size) {
                stack.addLast(i)
            }
        }

        return ret
    }

    fun nextGreaterElements2(nums: IntArray): IntArray {
        val heap = PriorityQueue<IntArray>(compareBy { it[1] }) // { index, nums[index] }
        val size = nums.size
        val ret = IntArray(size) { -1 }
        for (i in 0 until size * 2) {
            val next = nums[(i + 1) % size]
            if (i < size) {
                if (next <= nums[i % size]) {
                    heap.add(intArrayOf(i, nums[i]))
                } else {
                    ret[i] = next
                }
            }

            while (heap.isNotEmpty()) {
                val item = heap.peek()
                if (item!![1] < next) {
                    ret[item[0]] = next
                    heap.poll()
                } else {
                    break
                }
            }
        }

        return ret
    }
}