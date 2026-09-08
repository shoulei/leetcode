package com.leishou.solution

class MaximalRectangle {
    fun maximalRectangle(matrix: Array<CharArray>): Int {
        val row = matrix.size
        val col = matrix[0].size
        val histogram = IntArray(col) { 0 }
        var max = 0
        for (r in 0 until row) {
            for (c in 0 until col) {
                if (matrix[r][c] == '1') {
                    histogram[c]++
                } else {
                    histogram[c] = 0
                }
            }

            max = maxOf(max, getMaxRectangle(histogram))
        }

        return max
    }

    private fun getMaxRectangle(histogram: IntArray): Int {
        val size = histogram.size
        val queue = IntArray(size + 1)
        var maxRect = 0
        var top = -1
        for (i in 0..size) {
            val current = if (i == size) 0 else histogram[i]
            while (top >= 0 && histogram[queue[top]] > current) {
                val h = histogram[queue[top--]]
                val left = if (top < 0) -1 else queue[top]
                val width = i - left - 1
                maxRect = maxOf(maxRect, h * width)
            }

            queue[++top] = i
        }

        return maxRect
    }
}