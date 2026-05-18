package com.leishou.solution

import java.util.PriorityQueue

class TheSkylineProblem {
    fun getSkyline(buildings: Array<IntArray>): List<List<Int>> {
        val eventsList = mutableListOf<IntArray>().apply {
            for (it in buildings) {
                add(intArrayOf(it[0], it[2], it[1], 1))
                add(intArrayOf(it[1], it[2], it[1], 0))
            }
        }

        eventsList.sortWith(compareBy ({ it[0] }, { -it[3] }, { -it[1] }))

        val heap = PriorityQueue<IntArray>(compareByDescending { it[1] })
        val ret = mutableListOf<List<Int>>()
        var top: Int
        for (it in eventsList) {
            val h = it[1]
            val peek = heap.peek()
            top = peek?.get(1) ?: 0
            if (it[3] > 0) {
                if (h > top || it[2] > (peek?.get(0) ?: 0)) {
                    heap.add(intArrayOf(it[2], h))
                }
                if (h > top) {
                    ret.add(listOf(it[0], h))
                }
            } else {
                while (heap.isNotEmpty() && heap.peek()!![0] <= it[0]) {
                    heap.poll()
                }

                val tmpTop = heap.peek()?.get(1) ?: 0
                if (tmpTop < top) {
                    ret.add(listOf(it[0], tmpTop))
                }
            }
        }

        return ret
    }

    //data class BuildingEvent(val xPos: Int, val height: Int, val buildEnd: Int, val isEntering: Boolean)
    //data class Point(val quitX: Int, val height: Int)
}