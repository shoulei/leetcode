package com.leishou.solution

import com.leishou.solution.utils.ListNode
import org.junit.Test
import kotlin.test.assertContentEquals

class PartitionListTest {
    @Test
    fun testExample1() {
        val list = ListNode.intArrayToListNode(intArrayOf(1, 4, 3, 2, 5, 2))
        val target = intArrayOf(1, 2, 2, 4, 3, 5)
        assertContentEquals(target, ListNode.listNodeToIntArray(PartitionList().partition(list, 3)))
    }

    @Test
    fun testExample2() {
        val list = ListNode.intArrayToListNode(intArrayOf(2, 1))
        val target = intArrayOf(1, 2)
        assertContentEquals(target, ListNode.listNodeToIntArray(PartitionList().partition(list, 2)))
    }

    @Test
    fun testExample3() {
        val list = ListNode.intArrayToListNode(intArrayOf(1, 2, 3))
        val target = intArrayOf(1, 2, 3)
        assertContentEquals(target, ListNode.listNodeToIntArray(PartitionList().partition(list, 3)))
    }
}