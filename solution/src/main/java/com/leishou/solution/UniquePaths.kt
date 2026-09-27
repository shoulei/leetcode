package com.leishou.solution

class UniquePaths {
    fun uniquePaths(m: Int, n: Int): Int {
        val memo = Array(m) {
            IntArray(n) { -1 }
        }
        fun dfs(x: Int, y: Int): Int {
            if (x == m -1 || y == n - 1) {
                memo[x][y] = 1
                return 1
            }

            if (memo[x][y] != -1)
                return memo[x][y]

            val ret = dfs(x + 1, y) + dfs(x, y + 1)
            memo[x][y] = ret
            return ret
        }

        return dfs(0, 0)
    }
}