package com.leishou.solution

class RestoreIpAddresses {
    fun restoreIpAddresses(s: String): List<String> {
        val n = s.length
        if (n < 4 || n > 12)
            return emptyList()

        val memo = Array(n) {
            // -1 not initial, 0 false, 1 true
            IntArray(n + 1) { -1 }
        }

        // start inclusive and end exclusive
        fun isValid(start: Int, end: Int): Boolean {
            if (start > n - 1 || end > n)
                return false

            if (memo[start][end] != -1) {
                return memo[start][end] > 0
            }

            if (s[start] == '0') {
                return (end - start == 1).also {
                    memo[start][end] = if (it) 1 else 0
                }
            }

            if (end - start > 3) {
                memo[start][end] = 0
                return false
            }

            var value = 0
            for (i in start until end) {
                value = value * 10 + (s[i] - '0')
            }

            return (value < 256).also {
                memo[start][end] = if (it) 1 else 0
            }
        }

        val ret = mutableListOf<String>()
        val sb = StringBuilder()
        for (dot0 in 1 until 4) {
            if (!isValid(0, dot0))
                continue
            for (dot1 in dot0 + 1..minOf(dot0 + 3, n)) {
                if (!isValid(dot0, dot1))
                    continue
                for (dot2 in dot1 + 1..minOf(dot1 + 3, n)) {
                    sb.clear()
                    if (isValid(dot1, dot2) && isValid(dot2, n)) {
                        for (i in 0 until n) {
                            if (i == dot0 || i == dot1 || i == dot2)
                                sb.append('.')
                            sb.append(s[i])
                        }
                        ret.add(sb.toString())
                    }
                }
            }
        }

        return ret
    }
}