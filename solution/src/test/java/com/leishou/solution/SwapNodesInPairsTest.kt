package com.leishou.solution

import com.leishou.solution.utils.ListNode
import org.junit.Test
import kotlin.test.assertContentEquals

class SwapNodesInPairsTest {
    @Test
    fun testExample1() {
        val node = ListNode.intArrayToListNode(intArrayOf(1, 2, 3))
        val sol = SwapNodesInPairs()
        assertContentEquals(intArrayOf(2, 1, 3), ListNode.listNodeToIntArray(sol.swapPairs(node)))
    }

    @Test
    fun testExample2() {
        val node = ListNode.intArrayToListNode(intArrayOf(1, 2, 3, 4))
        val sol = SwapNodesInPairs()
        assertContentEquals(intArrayOf(2, 1, 4, 3), ListNode.listNodeToIntArray(sol.swapPairs(node)))
    }

    @Test
    fun testExample3() {
        val node = ListNode.intArrayToListNode(intArrayOf(1))
        val sol = SwapNodesInPairs()
        assertContentEquals(intArrayOf(1), ListNode.listNodeToIntArray(sol.swapPairs(node)))
    }

    @Test
    fun testExample4() {
        val node: ListNode? = null
        val sol = SwapNodesInPairs()
        assertContentEquals(intArrayOf(), ListNode.listNodeToIntArray(sol.swapPairs(node)))
    }
}