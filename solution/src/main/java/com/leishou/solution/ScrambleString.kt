package com.leishou.solution

class ScrambleString {
    fun isScramble(s1: String, s2: String): Boolean {
        val totalLen = s1.length
        if (totalLen != s2.length)
            return false

        // -1: uninitialized, 0: false 1: true
        val memo = Array(totalLen) {
            Array(totalLen) {
                IntArray(totalLen + 1) { -1 }
            }
        }
        // start inclusive and end exclusive
        fun dfs(s1Start: Int, s2Start: Int, length: Int): Boolean {
            if (memo[s1Start][s2Start][length] != -1) {
                return memo[s1Start][s2Start][length] > 0
            }

            if (length == 1) {
                return (s1[s1Start] == s2[s2Start]).also {
                    memo[s1Start][s2Start][1] = if (it) 1 else 0
                }
            }

            val normal = IntArray(26) { 0 }
            val reversed = IntArray(26) { 0 }
            val l = length - 1
            for (i in 0 until l) {
                normal[s1[i + s1Start] - 'a']++
                normal[s2[i + s2Start] - 'a']--
                if (normal.all { it == 0 }) {
                    if (dfs(s1Start, s2Start, i + 1) &&
                            dfs(s1Start + i + 1, s2Start + i + 1, length - i - 1)) {
                        memo[s1Start][s2Start][length] = 1
                        return true
                    }
                }

                reversed[s1[i + s1Start] - 'a']++
                reversed[s2[s2Start + length - i - 1] - 'a']--
                if (reversed.all { it == 0 }) {
                    if ((dfs(s1Start, s2Start + length - i - 1, i + 1) &&
                            dfs(s1Start + i + 1, s2Start, length - i - 1))) {
                        memo[s1Start][s2Start][length] = 1
                        return true
                    }
                }
            }

            memo[s1Start][s2Start][length] = 0
            return false
        }

        return dfs(0, 0, totalLen)
    }
}