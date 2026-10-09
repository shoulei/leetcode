package com.leishou.solution

import com.leishou.solution.utils.ListNode

/*
    You are given the head of a sorted linked list.
    Delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
    Return the linked list sorted as well.

    The number of nodes in the list is in the range [0, 300].
    -100 <= Node.val <= 100
    The list is guaranteed to be sorted in ascending order.
 */
class RemoveDuplicatesFromSortedListII {
    fun deleteDuplicates(head: ListNode?): ListNode? {
        val dummy = ListNode(0)
        var tail = dummy
        var current = head
        var hasDuplicated = false
        // pending note to add to new list, need confirm after check next node
        var pending: ListNode? = null
        var groupStart: ListNode? = null
        while (current != null) {
            if (groupStart == null) {
                groupStart = current
                pending = current
            } else {
                if (groupStart.`val` == current.`val`) {
                    hasDuplicated = true
                    pending = null
                } else {
                    if (!hasDuplicated) {
                        if (pending != null) {
                            tail.next = pending
                            tail = pending
                            tail.next = null
                        }
                    } else {
                        hasDuplicated = false
                    }
                    groupStart = current
                    pending = current
                }
            }

            current = current.next
        }

        if (pending != null) {
            tail.next = pending
        }

        return dummy.next
    }
}