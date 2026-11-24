package com.leishou.solution

import com.leishou.solution.utils.ListNode

/*
    Given the head of a linked list and a value x, partition it such that all nodes less than x come
    before nodes greater than or equal to x.
    You should preserve the original relative order of the nodes in each of the two partitions.

    The number of nodes in the list is in the range [0, 200].
    -100 <= Node.val <= 100
    -200 <= x <= 200
 */
class PartitionList {
    fun partition(head: ListNode?, x: Int): ListNode? {
        if (head?.next == null)
            return head

        val dummy = ListNode(0)
        var lessTail: ListNode = dummy
        var tail: ListNode? = null
        var current = head
        while (current != null) {
            val next = current.next
            if (current.`val` < x) {
                val noLessHead = lessTail.next
                lessTail.next = current
                lessTail = current
                lessTail.next = noLessHead
                if (tail == null || tail.`val` < x)
                    tail = current
            } else {
                if (tail == null)
                    tail = dummy
                tail.next = current
                tail = current
                tail.next = null
            }

            current = next
        }

        return dummy.next
    }
}