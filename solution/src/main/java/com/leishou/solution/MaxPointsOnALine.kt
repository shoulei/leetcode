package com.leishou.solution

import java.util.HashMap
import java.util.HashSet
import java.util.LinkedList
import kotlin.math.abs

/*
    Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane, return
    the maximum number of points that lie on the same straight line.

    1 <= points.length <= 300
    points[i].length == 2
    -10^4 <= xi, yi <= 10^4
    All the points are unique.
 */
class MaxPointsOnALine {
    fun maxPoints(points: Array<IntArray>): Int {
        val n = points.size
        if (n <= 2)
            return n

        var maxPoints = 0
        val lineMap = HashMap<Long, Int>()
        for (i in 0 until n) {
            val p0 = points[i]
            lineMap.clear()
            for (j in i + 1 until n) {
                val p1 = points[j]
                var dx = p1[0] - p0[0]
                var dy = p1[1] - p0[1]
                val gcd = commonGreatestDivisor(abs(dx), abs(dy))
                dx /= gcd
                dy /= gcd
                if (dx < 0 || (dx == 0 && dy < 0)) {
                    dx = -dx
                    dy = -dy
                }
                val key = (dx.toLong() shl 32) or (dy.toUInt()).toLong()
                val ct = lineMap.getOrDefault(key, 1) + 1
                lineMap[key] = ct
                maxPoints = maxOf(maxPoints, ct)
            }
        }

        return maxPoints
    }

    private fun commonGreatestDivisor(a: Int, b: Int): Int {
        if (a == 0)
            return b
        return commonGreatestDivisor(b % a, a)
    }
}