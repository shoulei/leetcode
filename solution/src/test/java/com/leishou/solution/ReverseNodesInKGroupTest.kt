package com.leishou.solution

import org.junit.Assert.assertArrayEquals
import org.junit.Test

class ReverseNodesInKGroupTest {
    @Test
    fun testExample1() {
        val sol = ReverseNodesInKGroup()
        val ret = sol.reverseKGroup(ListNode.intArrayToListNode(intArrayOf(1, 2, 3, 4, 5)), 2)
        assertArrayEquals(intArrayOf(2, 1, 4, 3, 5), ListNode.listNodeToIntArray(ret))
    }

    @Test
    fun testExample2() {
        val sol = ReverseNodesInKGroup()
        val ret = sol.reverseKGroup(ListNode.intArrayToListNode(intArrayOf(1, 2, 3, 4, 5)), 3)
        assertArrayEquals(intArrayOf(3, 2, 1, 4, 5), ListNode.listNodeToIntArray(ret))
    }
}