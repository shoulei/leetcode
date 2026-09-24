package com.leishou.solution

/*
    You have intercepted a secret message encoded as a string of numbers. The message is decoded
    via the following mapping:
        "1" -> 'A'
        "2" -> 'B'
        ...
        "25" -> 'Y'
        "26" -> 'Z'
    However, while decoding the message, you realize that there are many different ways you can
    decode the message because some codes are contained in other codes ("2" and "5" vs "25").
    For example, "11106" can be decoded into:
        "AAJF" with the grouping (1, 1, 10, 6)
        "KJF" with the grouping (11, 10, 6)
        The grouping (1, 11, 06) is invalid because "06" is not a valid code (only "6" is valid).

    Note: there may be strings that are impossible to decode.
    Given a string s containing only digits, return the number of ways to decode it.
    If the entire string cannot be decoded in any valid way, return 0.

    The test cases are generated so that the answer fits in a 32-bit integer.
 */
class DecodeWays {
    fun numDecodings(s: String): Int {
        val n = s.length
        val memo = IntArray(n) { -1 }

        fun dfs(index: Int): Int {
            if (index >= n)
                return 1

            if (memo[index] != -1)
                return memo[index]

            var ret = 0
            val current = s[index]
            if (current == '0') {
                memo[index] = 0
                return 0
            }

            ret += dfs(index + 1)
            if (index < n - 1) {
                val next = s[index + 1]
                if ((current - '0') * 10 + (next - '0') <= 26) {
                    ret += dfs(index + 2)
                }
            }

            memo[index] = ret
            return ret
        }

        return dfs(0)
    }

    fun numDecodings_(s: String): Int {
        var dp2 = 1 // dp[i - 2]
        var dp1 = 1 // dp[i - 1]
        for (i in s.indices) {
            val c = s[i]
            var dp0 = 0
            if (c != '0') {
                dp0 += dp1
            }

            if (i > 0) {
                val pre = s[i - 1]
                if (pre != '0' && (pre - '0') * 10 + (c - '0') <= 26) {
                    dp0 += dp2
                }
            }

            dp2 = dp1
            dp1 = dp0
        }

        return dp1
    }
}