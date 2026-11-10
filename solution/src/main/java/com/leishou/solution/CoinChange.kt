package com.leishou.solution

/*
    You are given an integer array coins representing coins of different denominations and an
    integer amount representing a total amount of money.

    Return the fewest number of coins that you need to make up that amount. If that amount of money
    cannot be made up by any combination of the coins, return -1.

    You may assume that you have an infinite number of each kind of coin.

    1 <= coins.length <= 12
    1 <= coins[i] <= 2^31 - 1
    0 <= amount <= 10^4
 */
class CoinChange {
    fun coinChange(coins: IntArray, amount: Int): Int {
        val dp = IntArray(amount + 1) { amount + 1 }
        dp[0] = 0
        for (coin in coins) {
            for (num in coin..amount) {
                dp[num] = minOf(dp[num], dp[num - coin] + 1)
            }
        }

        val ret = dp[amount]
        return if (ret > amount) -1 else ret
    }

    fun coinChange_(coins: IntArray, amount: Int): Int {
        val n = coins.size
        val dp = Array(n) {
            IntArray(amount + 1) { -1 }
        }

        fun dfs(index: Int, remain: Int): Int {
            if (remain == 0 && index < n) {
                dp[index][remain] = 0
                return 0
            }

            if (index >= n) {
                return amount + 1
            }

            if (dp[index][remain] >= 0)
                return dp[index][remain]

            val skip = dfs(index + 1, remain)
            val take = if (remain >= coins[index]) {
                dfs(index, remain - coins[index]) + 1
            } else {
                amount + 1
            }

            return minOf(skip, take).also {
                dp[index][remain] = it
            }
        }

        val ret = dfs(0, amount)
        return if (ret > amount) -1 else ret
    }
}