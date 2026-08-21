package com.leishou.solution

import com.leishou.solution.utils.ListNode

class SwapNodesInPairs {
    fun swapPairs(head: ListNode?): ListNode? {
        var next = head
        val dummy = ListNode(0)
        var current: ListNode = dummy
        while (next != null) {
            if (next.next != null) {
                val temp = next.next!!.next
                current.next = next.next
                current = current.next!!
                current.next = next
                current = next
                current.next = null
                next = temp
            } else {
                current.next = next
                current = next
                next = null
            }
        }

        return dummy.next
    }
}