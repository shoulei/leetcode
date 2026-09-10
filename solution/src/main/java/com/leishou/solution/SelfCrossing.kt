package com.leishou.solution

class SelfCrossing {
    /*
        You are given an array of integers distance.
        You start at the point (0, 0) on an X-Y plane,
        and you move distance[0] meters to the north, then distance[1] meters to the west,
        distance[2] meters to the south, distance[3] meters to the east, and so on. In other words,
        after each move, your direction changes counter-clockwise.

        Return true if your path crosses itself or false if it does not.
    */
    fun isSelfCrossing(distance: IntArray): Boolean {
        val size = distance.size
        for (i in 3 until size) {
            // d[i] cross with d[i-3]
            if (distance[i - 1] <= distance[i - 3] && distance[i] >= distance[i - 2]) {
                return true
            }

            // d[i] cross with d[i-4]
            if (i >= 4 && distance[i - 3] == distance[i - 1] && distance[i] + distance[i - 4] >= distance[i - 2]) {
                return true
            }

            // d[i] cross with d[i-5]
            if (i >= 5 && distance[i - 1] + distance[i - 5] >= distance[i - 3] &&
                distance[i] + distance[i - 4] >= distance[i - 2] &&
                distance[i - 2] > distance[i - 4] && distance[i - 3] > distance[i - 1]) {
                return true
            }
        }

        return false
    }
}