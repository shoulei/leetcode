package com.leishou.solution

class SpiralMatrix {
    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
        val row = matrix.size
        val col = matrix[0].size
        val totalCt = row * col
        var direct = 0 // 0: rightward, 1: downward, 2: leftward, 3: upward
        var right = col - 1
        var left = 0
        var top = 1 // top line will be iterated by default
        var bottom = row - 1
        val ret = mutableListOf<Int>()
        var x = 0
        var y = 0
        for (i in 0 until totalCt) {
            ret.add(matrix[x][y])
            when (direct) {
                0 -> {
                    if (y == right) {
                        direct = 1
                        x++
                    } else {
                        y++
                        if (y == right) {
                            direct = 1
                            right--
                        }
                    }
                }

                1 -> {
                    x++
                    if (x == bottom) {
                        direct = 2
                        bottom--
                    }
                }

                2 -> {
                    y--
                    if (y == left) {
                        direct = 3
                        left++
                    }
                }

                else -> {
                    x--
                    if (x == top) {
                        direct = 0
                        top++
                    }
                }
            }
        }

        return ret
    }
}