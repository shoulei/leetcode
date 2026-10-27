package com.leishou.solution

/*
    You are given an integer array lights of length n, representing positions 0 through n - 1 on
    a road. For each position i:
    1, If lights[i] = v, where v > 0, there is a working bulb at position i that illuminates every
    position from max(0, i - v) to min(n - 1, i + v), inclusive.
    2, If lights[i] = 0, there is no working bulb at position i.
    A position is visible if it is illuminated by at least one working bulb.
    You may install additional bulbs at any positions. Each additional bulb installed at position j
    illuminates positions from max(0, j - 1) to min(n - 1, j + 1), inclusive.

    Return the minimum number of additional bulbs required to make every position on the road visible.

    1 <= n == lights.length <= 10^5
    0 <= lights[i] <= n
 */
class MinimumLightsToIlluminateARoad {
    fun minLights(lights: IntArray): Int {
        val n = lights.size
        var rightMost = -1
        var i = 0
        var additionalBulbs = 0
        val bubblePosArray = IntArray(n) { - 1 }
        var top = -1
        while (i < n) {
            when (val radius = lights[i]) {
                0 -> {
                    if (rightMost < i - 1) {
                        additionalBulbs++
                        rightMost = i + 1
                        bubblePosArray[++top] = i
                    }
                }

                else -> {
                    val reach = i + radius
                    val start = i - radius
                    if (rightMost < reach) {
                        while (top >= 0) {
                            val pos = bubblePosArray[top]
                            if (pos > start && additionalBulbs > 0) {
                                top--
                                additionalBulbs--
                            } else {
                                break
                            }
                        }

                        rightMost = reach
                    }
                }
            }

            i++
        }

        if (rightMost < n - 1)
            additionalBulbs++

        return additionalBulbs
    }
}