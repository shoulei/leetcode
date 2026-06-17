package com.leishou.solution

class ListNode(var `val`: Int) {
    var next: ListNode? = null

    companion object {
        fun intArrayToListNode(nums: IntArray): ListNode {
            val dummy = ListNode(0)
            var cur = dummy
            for (i in nums.indices) {
                cur.next = ListNode(nums[i])
                cur = cur.next!!
            }
            return dummy.next!!
        }

        fun listNodeToIntArray(node: ListNode?): IntArray {
            var cur = node
            val list = mutableListOf<Int>()
            while (cur != null) {
                list.add(cur.`val`)
                cur = cur.next
            }

            return list.toIntArray()
        }
    }
}