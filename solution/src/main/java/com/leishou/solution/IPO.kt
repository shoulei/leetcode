package com.leishou.solution

import java.util.PriorityQueue

class IPO {
    fun findMaximizedCapital(k: Int, w: Int, profits: IntArray, capital: IntArray): Int {
        val n = profits.size
        val projects = LongArray(n) { (capital[it].toLong() shl 32) or (it.toLong() and 0xFFFFFFFFL) }
        projects.sort()

        val available = PriorityQueue<Int> { a, b -> b.compareTo(a) }
        var ret = w
        var smallestCap = 0

        fun recurse(remainK: Int) {
            if (remainK == 0)
                return

            while (smallestCap < n && (projects[smallestCap] shr 32).toInt() <= ret) {
                available.add(profits[projects[smallestCap++].toInt()])
            }

            if (available.isEmpty())
                return

            ret += available.poll()!!
            recurse(remainK - 1)
        }

        recurse(k)
        return ret
    }
}