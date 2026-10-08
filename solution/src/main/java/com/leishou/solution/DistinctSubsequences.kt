package com.leishou.solution

/*
    Given two strings s and t, return the number of distinct subsequences of s which equals t.
    The test cases are generated so that the answer fits on a 32-bit signed integer.

    1 <= s.length, t.length <= 1000
    s and t consist of English letters.
 */
class DistinctSubsequences {
    fun numDistinct(s: String, t: String): Int {
        val sLen = s.length
        val tLen = t.length
        val dp = IntArray(tLen + 1) { 0 }
        dp[0] = 1

        for (i in 0 until sLen) {
            for (j in tLen - 1 downTo 0) {
                if (s[i] == t[j]) {
                    dp[j + 1] += dp[j]
                }
            }
        }

        return dp[tLen]
    }

    fun numDistinct_(s: String, t: String): Int {
        val sLen = s.length
        val tLen = t.length
        val memo = Array(sLen) {
            IntArray(tLen) { -1 } // -1: uninitialized
        }

        fun dfs(sIndex: Int, tIndex: Int): Int {
            if (tIndex >= tLen) {
                return 1
            } else if (sIndex >= sLen) {
                return 0
            }

            // simple +/- faster than memo pick
            if (sLen - sIndex < tLen - tIndex)
                return 0

            if (memo[sIndex][tIndex] != -1)
                return memo[sIndex][tIndex]

            var ret: Int
            if (s[sIndex] != t[tIndex]) {
                ret = dfs(sIndex + 1, tIndex)
            } else {
                ret = dfs(sIndex + 1, tIndex) // not consume tIndex
                ret += dfs(sIndex + 1, tIndex + 1)
            }

            memo[sIndex][tIndex] = ret
            return ret
        }

        return dfs(0, 0)
    }
}