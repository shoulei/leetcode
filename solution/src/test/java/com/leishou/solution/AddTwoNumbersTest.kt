package com.leishou.solution

import com.leishou.solution.utils.ListNode
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
        val result = sol.addTwoNumbers(ListNode.intArrayToListNode(intArrayOf(2, 4, 3)), ListNode.intArrayToListNode(intArrayOf(5, 6, 4)))
        assertArrayEquals(intArrayOf(7, 0, 8), ListNode.listNodeToIntArray(result))
    }

    @Test
    fun testExample2() {
        val sol = AddTwoNumbers()
        val result = sol.addTwoNumbers(ListNode.intArrayToListNode(intArrayOf(0)), ListNode.intArrayToListNode(intArrayOf(0)))
        assertArrayEquals(intArrayOf(0), ListNode.listNodeToIntArray(result))
    }

    @Test
    fun testExample3() {
        val sol = AddTwoNumbers()
        val result = sol.addTwoNumbers(ListNode.intArrayToListNode(intArrayOf(9, 9, 9, 9, 9, 9, 9)), ListNode.intArrayToListNode(intArrayOf(9, 9, 9, 9)))
        assertArrayEquals(intArrayOf(8, 9, 9, 9, 0, 0, 0, 1), ListNode.listNodeToIntArray(result))
    }
}