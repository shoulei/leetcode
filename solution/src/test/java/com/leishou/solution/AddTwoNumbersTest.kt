package com.leishou.solution

import org.junit.Assert.assertArrayEquals
import org.junit.Test

/*
  You are given two non-empty linked lists representing two non-negative integers.
  The digits are stored in reverse order, and each of their nodes contains a single digit.
  Add the two numbers and return the sum as a linked list.
  You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 */
class AddTwoNumbersTest {
    @Test
    fun testExample1() {
        val sol = AddTwoNumbers()
        val result = sol.addTwoNumbers(intArrayToListNode(intArrayOf(2, 4, 3)), intArrayToListNode(intArrayOf(5, 6, 4)))
        assertArrayEquals(intArrayOf(7, 0 ,8), listNodeToIntArray(result))
    }

    @Test
    fun testExample2() {
        val sol = AddTwoNumbers()
        val result = sol.addTwoNumbers(intArrayToListNode(intArrayOf(0)), intArrayToListNode(intArrayOf(0)))
        assertArrayEquals(intArrayOf(0), listNodeToIntArray(result))
    }

    @Test
    fun testExample3() {
        val sol = AddTwoNumbers()
        val result = sol.addTwoNumbers(intArrayToListNode(intArrayOf(9, 9, 9, 9, 9, 9, 9)), intArrayToListNode(intArrayOf(9, 9, 9, 9)))
        assertArrayEquals(intArrayOf(8, 9, 9, 9, 0, 0, 0, 1), listNodeToIntArray(result))
    }

    private fun intArrayToListNode(nums: IntArray): AddTwoNumbers.ListNode {
        val dummy = AddTwoNumbers.ListNode(0)
        var cur = dummy
        for (i in nums.indices) {
            cur.next = AddTwoNumbers.ListNode(nums[i])
            cur = cur.next!!
        }
        return dummy.next!!
    }

    private fun listNodeToIntArray(node: AddTwoNumbers.ListNode?): IntArray {
        var cur = node
        val list = mutableListOf<Int>()
        while (cur != null) {
            list.add(cur.`val`)
            cur = cur.next
        }

        return list.toIntArray()
    }
}