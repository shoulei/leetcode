package com.leishou.solution

import com.leishou.solution.utils.ListNode
import org.junit.Test
import kotlin.test.assertContentEquals

class RemoveNthNodeFromEndOfListTest {
    @Test
    fun testExample1() {
        val sol = RemoveNthNodeFromEndOfList()
        val node = ListNode.intArrayToListNode(intArrayOf(1, 2, 3, 4, 5))
        val result = sol.removeNthFromEnd(node, 2)
        assertContentEquals(intArrayOf(1, 2, 3, 5), ListNode.listNodeToIntArray(result))
    }

    @Test
    fun testExample2() {
        val sol = RemoveNthNodeFromEndOfList()
        val node = ListNode.intArrayToListNode(intArrayOf(1))
        val result = sol.removeNthFromEnd(node, 1)
        assertContentEquals(intArrayOf(), ListNode.listNodeToIntArray(result))
    }

    @Test
    fun testExample3() {
        val sol = RemoveNthNodeFromEndOfList()
        val node = ListNode.intArrayToListNode(intArrayOf(1, 2))
        val result = sol.removeNthFromEnd(node, 1)
        assertContentEquals(intArrayOf(1), ListNode.listNodeToIntArray(result))
    }
}