package com.leishou.solution

import kotlin.math.min

class ContainerWithMostWater {
    fun maxArea(height: IntArray): Int {
        var max = 0
        val size = height.size
        var left = 0
        var right = size - 1
        while (left < right) {
            val area = (right - left) * min(height[left], height[right])
            if (area > max) {
                max = area
            }

            if (height[left] < height[right]) {
                left++
            } else {
                right--
            }
        }

        return max
    }
}