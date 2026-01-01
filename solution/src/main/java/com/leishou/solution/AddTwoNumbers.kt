package com.leishou.solution

class AddTwoNumbers {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        val dummy = ListNode(0)
        var current: ListNode = dummy
        var t1: ListNode? = l1
        var t2: ListNode? = l2
        var carry = 0
        while (t1 != null || t2 != null || carry > 0) {
            val v: Int = (t1?.`val`?: 0) + (t2?.`val`?: 0) + carry
            current.next = ListNode(v % 10)
            carry = v / 10
            current = current.next!!

            t1 = t1?.next
            t2 = t2?.next
        }

        return dummy.next
    }

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }
}