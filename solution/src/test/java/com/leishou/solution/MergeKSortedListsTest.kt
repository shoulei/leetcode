package com.leishou.solution

import org.junit.Assert.assertArrayEquals
import org.junit.Test

class MergeKSortedListsTest {
    @Test
    fun testExample1() {
        val sol = MergeKSortedLists()
        val ret = sol.mergeKLists(arrayOf(ListNode.intArrayToListNode(intArrayOf(1, 4, 5)),
            ListNode.intArrayToListNode(intArrayOf(1, 3, 4)),
            ListNode.intArrayToListNode(intArrayOf(2, 6))))
        assertArrayEquals(intArrayOf(1, 1, 2, 3, 4, 4, 5, 6), ListNode.listNodeToIntArray(ret))
    }

    @Test
    fun testExample2() {
        val sol = MergeKSortedLists()
        val ret = sol.mergeKLists(emptyArray())
        assertArrayEquals(intArrayOf(), ListNode.listNodeToIntArray(ret))
    }

    @Test
    fun testExample3() {
        val sol = MergeKSortedLists()
        val ret = sol.mergeKLists(arrayOf(ListNode.intArrayToListNode(intArrayOf(1, 1, 2)),
            ListNode.intArrayToListNode(intArrayOf(1, 2, 2))))
        assertArrayEquals(intArrayOf(1, 1, 1, 2, 2, 2), ListNode.listNodeToIntArray(ret))
    }
}