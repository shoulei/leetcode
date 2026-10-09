package com.leishou.solution

import com.leishou.solution.utils.ListNode
import org.junit.Test
import kotlin.test.assertEquals

class RemoveDuplicatesFromSortedListIITest {
    @Test
    fun testExample1() {
        val list = ListNode.intArrayToListNode(intArrayOf(1, 2, 3, 3, 4, 4, 5))
        val result = RemoveDuplicatesFromSortedListII().deleteDuplicates(list)
        assertEquals(intArrayOf(1, 2, 5).toList(), ListNode.listNodeToIntArray(result).toList())
    }

    @Test
    fun testExample2() {
        val list = ListNode.intArrayToListNode(intArrayOf(1, 1, 1, 2, 3))
        val result = RemoveDuplicatesFromSortedListII().deleteDuplicates(list)
        assertEquals(intArrayOf(2, 3).toList(), ListNode.listNodeToIntArray(result).toList())
    }

    @Test
    fun testExample3() {
        val list = ListNode.intArrayToListNode(intArrayOf(1, 2, 3, 3, 4, 4))
        val result = RemoveDuplicatesFromSortedListII().deleteDuplicates(list)
        assertEquals(intArrayOf(1, 2).toList(), ListNode.listNodeToIntArray(result).toList())
    }
}