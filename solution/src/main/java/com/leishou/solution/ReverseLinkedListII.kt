package com.leishou.solution

import com.leishou.solution.utils.ListNode

/*
    Given the head of a singly linked list and two integers left and right where left <= right,
    reverse the nodes of the list from position left to position right, and return the reversed list.

    The number of nodes in the list is n.
    1 <= n <= 500
    -500 <= Node.val <= 500
    1 <= left <= right <= n
 */
class ReverseLinkedListII {
    fun reverseBetween(head: ListNode?, left: Int, right: Int): ListNode? {
        if (head == null || left == right)
            return head

        val dummy = ListNode(0)
        dummy.next = head
        var previous: ListNode = dummy
        repeat(left - 1) {
            previous = previous.next!!
        }

        val tail: ListNode = previous.next!!
        repeat(right - left) {
            val move = tail.next!!
            tail.next = move.next
            move.next = previous.next
            previous.next = move
        }

        return dummy.next
    }
}