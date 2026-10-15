package com.leishou.solution

import com.leishou.solution.utils.ListNode

/*
    Given the head of a linked list, remove the nth node from the end of the list and return its head.

    The number of nodes in the list is sz.
    1 <= sz <= 30
    0 <= Node.val <= 100
    1 <= n <= sz
 */
class RemoveNthNodeFromEndOfList {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        val dummy = ListNode(0)
        var current = head
        var copiedHead: ListNode = dummy
        var copiedLen = 0
        var tail = dummy
        while (current != null) {
            tail.next = current
            tail = tail.next!!
            copiedLen++
            if (copiedLen > n) {
                copiedLen = n
                copiedHead = copiedHead.next!!
            }
            current = current.next
        }

        copiedHead.next = copiedHead.next?.next
        return dummy.next
    }
}