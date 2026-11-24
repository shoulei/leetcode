package com.leishou.solution

/*
    Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right,
    which minimizes the sum of all numbers along its path.

    Note: You can only move either down or right at any point in time.

    m == grid.length
    n == grid[i].length
    1 <= m, n <= 200
    0 <= grid[i][j] <= 200
 */
class MinimumPathSum {
    fun minPathSum(grid: Array<IntArray>): Int {
        if (grid.isEmpty())
            return 0
        val m = grid.size
        val n = grid[0].size
        val dp = Array(m) {
            IntArray(n) { -1 }
        }

        fun dfs(x: Int, y: Int): Int {
            if (dp[x][y] >= 0)
                return dp[x][y]

            dp[x][y] = when {
                x == 0 && y == 0 -> grid[0][0]
                x == 0 -> grid[0][y] + dfs(0, y - 1)
                y == 0 -> grid[x][0] + dfs(x - 1, 0)
                else -> minOf(dfs(x - 1, y), dfs(x, y - 1)) + grid[x][y]
            }

            return dp[x][y]
        }

        return dfs(m - 1, n - 1)
    }
}