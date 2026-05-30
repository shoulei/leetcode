package com.leishou.solution

import kotlin.math.min

class Triangle {
    fun minimumTotal(triangle: List<List<Int>>): Int {
        val row = triangle.size
        val ret = triangle[row - 1].toIntArray()
        for (i in row - 2 downTo 0) {
            for (j in 0 until i + 1) {
                ret[j] = triangle[i][j] + min(ret[j], ret[j + 1])
            }
        }

        return ret[0]
    }
}