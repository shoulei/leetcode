package com.leishou.solution

class DungeonGame {
    fun calculateMinimumHP(dungeon: Array<IntArray>): Int {
        val rows = dungeon.size
        val cols = dungeon[0].size
        val dp = Array(rows) {
            IntArray(cols)
        }

        dp[rows - 1][cols - 1] = maxOf(1, 1 - dungeon[rows - 1][cols - 1])
        for (i in rows - 2 downTo 0) {
            dp[i][cols - 1] = maxOf(1, dp[i + 1][cols - 1] - dungeon[i][cols - 1])
        }

        for (j in cols - 2 downTo 0) {
            dp[rows - 1][j] = maxOf(1, dp[rows - 1][j + 1] - dungeon[rows - 1][j])
        }

        for (i in rows - 2 downTo 0) {
            for (j in cols - 2 downTo 0) {
                val need = minOf(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j]
                dp[i][j] = maxOf(1, need)
            }
        }

        return dp[0][0]
    }
}