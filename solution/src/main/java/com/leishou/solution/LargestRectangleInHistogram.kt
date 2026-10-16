package com.leishou.solution

class LargestRectangleInHistogram {
    fun largestRectangleArea(heights: IntArray): Int {
        val n = heights.size
        val queue = ArrayDeque<Int>()
        var maxArea = 0
        for (i in 0..n) {
            val current = if (i < n) heights[i] else 0
            while (queue.isNotEmpty() && heights[queue.last()] > current) {
                val h = heights[queue.last()]
                queue.removeLast()
                val left = if (queue.isEmpty()) -1 else queue.last()
                maxArea = maxOf(maxArea, h * (i - left - 1))
            }
            queue.addLast(i)
        }

        return maxArea
    }

    fun largestRectangleArea_(heights: IntArray): Int {
        val size = heights.size
        val queue = IntArray(size + 1)
        var top = -1
        var largest = 0
        for (i in 0..size) {
            val current = if (i < size) heights[i] else 0
            while (top >= 0 && heights[queue[top]] > current) {
                val height = heights[queue[top--]]
                val left = if (top < 0) -1 else queue[top]
                largest = maxOf(largest, height * (i - left - 1))
            }
            queue[++top] = i
        }

        return largest
    }
}