package com.leishou.solution

import com.leishou.solution.utils.ListNode
import org.junit.Test
import kotlin.test.assertContentEquals

class ReverseLinkedListIITest {
    @Test
    fun testExample1() {
        val sol = ReverseLinkedListII()
        val listNode = ListNode.intArrayToListNode(intArrayOf(1, 2, 3, 4, 5))
        assertContentEquals(intArrayOf(1, 4, 3, 2, 5), ListNode.listNodeToIntArray(sol.reverseBetween(listNode, 2, 4)))
    }

    @Test
    fun testExample2() {
        val sol = ReverseLinkedListII()
        val listNode = ListNode.intArrayToListNode(intArrayOf(5))
        assertContentEquals(intArrayOf(5), ListNode.listNodeToIntArray(sol.reverseBetween(listNode, 1, 1)))
    }

    @Test
    fun testExample3() {
        val sol = ReverseLinkedListII()
        val listNode = ListNode.intArrayToListNode(intArrayOf(3, 5))
        assertContentEquals(intArrayOf(5, 3), ListNode.listNodeToIntArray(sol.reverseBetween(listNode, 1, 2)))
    }
}