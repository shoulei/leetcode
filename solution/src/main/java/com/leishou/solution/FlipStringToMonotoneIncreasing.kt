package com.leishou.solution

class FlipStringToMonotoneIncreasing {
    fun minFlipsMonoIncr(s: String): Int {
        var dp0Flip = 0
        var dp1Flip = 0
        for (i in s.indices) {
            val min = if (dp0Flip < dp1Flip) dp0Flip else dp1Flip
            if (s[i] == '0') {
                dp1Flip = 1 + min
            } else {
                dp0Flip++
                dp1Flip = min
            }
        }

        return if (dp0Flip < dp1Flip) dp0Flip else dp1Flip
    }

    fun minFlipsMonoIncr_(s: String): Int {
        var isZero: Boolean? = null
        val countArray = IntArray(s.length) { -1 }
        var count = 0
        var top = 0
        for (c in s) {
            if (c == '0') {
                if (isZero == null) {
                    continue
                } else if (isZero) {
                    count++
                } else {
                    if (count > 0)
                        countArray[top++] = count
                    count = 1
                }
                isZero = true
            } else {
                if (isZero != false) {
                    if (count > 0) {
                        countArray[top++] = count
                    }
                    count = 1
                } else {
                    count++
                }
                isZero = false
            }
        }

        if (count > 0)
            countArray[top++] = count

        fun dfs(index: Int): Int {
            if (index >= top - 1) {
                return 0
            }

            if (countArray[index] < countArray[index + 1]) {
                return countArray[index] + dfs(index + 2)
            } else {
                var left = 0
                var j = index + 1
                while (j < top) {
                    left += countArray[j]
                    j += 2
                }
                return minOf(countArray[index] + dfs(index + 2), left )
            }
        }

        return dfs(0)
    }
}