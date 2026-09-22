package com.leishou.solution

/*
    Given n non-negative integers representing an elevation map where the width of each bar is 1,
    compute how much water it can trap after raining.
 */
class TrappingRainWater {
    fun trap(height: IntArray): Int {
        val n = height.size
        var left = 0
        var right = n - 1
        var leftMax = 0
        var rightMax = 0
        var ret = 0
        while (left < right) {
            if (height[left] < height[right]) {
                if (leftMax < height[left]) {
                    leftMax = height[left]
                } else {
                    ret += leftMax - height[left]
                }
                left++
            } else {
                if (rightMax < height[right]) {
                    rightMax = height[right]
                } else {
                    ret += rightMax - height[right]
                }
                right--
            }
        }

        return ret
    }

    fun trap_(height: IntArray): Int {
        val n = height.size
        val packArray = LongArray(n) {
            (height[it].toLong() shl 32) or (it.toLong() and 0xFFFFFFFFL)
        }

        packArray.sortDescending()
        fun expandLeft(index: Int, packIndex: Int): Int {
            if (index <= 0)
                return 0

            var nextLeft = -1
            var nextPackLeft = 0
            for (i in packIndex + 1 until n - 1) {
                val left = packArray[i].toInt()
                if (left < index) {
                    nextLeft = left
                    nextPackLeft = i
                    break
                }
            }

            var ret = 0
            if (nextLeft >= 0) {
                val h = height[nextLeft]
                for (i in nextLeft + 1 until index) {
                    ret += h - height[i]
                }

                return expandLeft(nextLeft, nextPackLeft) + ret
            }

            return 0
        }

        fun expandRight(index: Int, packIndex: Int): Int {
            if (index > n - 1)
                return 0

            var nextRight = n
            var nextPackRight = 0
            for (i in packIndex + 1 until n - 1) {
                val right = packArray[i].toInt()
                if (right > index) {
                    nextRight = right
                    nextPackRight = i
                    break
                }
            }

            var ret = 0
            if (nextRight <= n - 1) {
                val h = height[nextRight]
                for (i in index + 1 until nextRight) {
                    ret += h - height[i]
                }

                return expandRight(nextRight, nextPackRight) + ret
            }

            return 0
        }

        val firstHIndex = packArray[0].toInt()
        return expandLeft(firstHIndex, 0) + expandRight(firstHIndex, 0)
    }
}