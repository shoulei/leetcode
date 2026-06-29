package com.leishou.solution

import com.leishou.solution.utils.ListNode
import java.util.PriorityQueue

class MergeKSortedLists {
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        val ret = ListNode(0)
        val heap = PriorityQueue<ListNode>(compareBy { it.`val` })
        // initial
        for (l in lists) {
            if (l != null) {
                heap.add(l)
            }
        }

        var current: ListNode = ret
        while (true) {
            heap.poll()?.let { item ->
                val value = item.`val`
                current.next = item
                current = item

                while (current.next?.`val` == value) {
                    current = current.next!!
                }

                current.next?.let { next ->
                    heap.add(next)
                }
            }

            if (heap.isEmpty()) {
                current.next = null
                break
            }
        }

        return ret.next
    }
}