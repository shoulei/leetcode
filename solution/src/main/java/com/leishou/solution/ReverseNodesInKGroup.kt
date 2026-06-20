package com.leishou.solution

class ReverseNodesInKGroup {
    fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
        if (head == null || k == 1)
            return head

        val ret = ListNode(0)
        var tail: ListNode = ret
        var groupTail: ListNode = ret
        var next: ListNode? = null
        var cur: ListNode? = head
        var i = 0
        while (cur != null) {
            if (i == 0) {
                groupTail = cur
            }

            next = cur.next
            cur.next = tail.next
            tail.next = cur

            if (i == k - 1) {
                tail = groupTail
            }

            cur = next
            i = (i + 1) % k
        }

        cur = tail.next
        tail.next = null
        while (cur != null) {
            next = cur.next
            cur.next = tail.next
            tail.next = cur
            cur = next
        }

        return ret.next
    }
}