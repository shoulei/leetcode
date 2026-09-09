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
        val pointsArray = Array(size + 1) { IntArray(2) }
        pointsArray[0] = intArrayOf(0, 0)
        var x = 0
        var y = 0
        for (i in 0 until size) {
            val direction = i % 4
            when (direction) {
                0 -> y += distance[i]
                1 -> x -= distance[i]
                2 -> y -= distance[i]
                else -> x += distance[i]
            }
            pointsArray[i + 1] = intArrayOf(x, y)
        }

        if (pointsArray[size][0] == 0 && pointsArray[size][1] == 0)
            return true

        var vertical = 0
        while (vertical < size) {
            val p1 = pointsArray[vertical]
            val p2 = pointsArray[vertical + 1]
            var horizon = 1
            while (horizon < size) {
                val p3 = pointsArray[horizon]
                val p4 = pointsArray[horizon + 1]
                val diff = if (vertical > horizon) vertical - horizon else horizon - vertical
                if (isCrossing(p1, p2, p3, p4) && diff != 1) {
                    return true
                }
                horizon += 2
            }

            vertical += 2

        }

        return false
    }

    private fun isCrossing(vStart: IntArray, vEnd: IntArray, hStart: IntArray, hEnd: IntArray): Boolean {
        val vX = vStart[0]
        val hY = hStart[1]

        return ((vX >= hStart[0] && vX <= hEnd[0]) || (vX >= hEnd[0] && vX <= hStart[0])) &&
                ((hY >= vStart[1] && hY <= vEnd[1]) || (hY >= vEnd[1] && hY <= vStart[1]))

    }
}