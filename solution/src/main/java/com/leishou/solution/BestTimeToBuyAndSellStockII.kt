package com.leishou.solution
/*
    You are given an integer array prices where prices[i] is the price of a given stock on the ith
    day. On each day, you may decide to buy and/or sell the stock. You can only hold at most one
    share of the stock at any time. However, you can sell and buy the stock multiple times on the
    same day, ensuring you never hold more than one share of the stock.

    Find and return the maximum profit you can achieve.
 */
class BestTimeToBuyAndSellStockII {
    fun maxProfit(prices: IntArray): Int {
        val size = prices.size
        if (size < 2)
            return 0

        var ret = 0
        for (i in 0 until size - 1) {
            if (prices[i + 1] > prices[i]) {
                ret += prices[i + 1] - prices[i]
            }
        }

        return ret
    }

    fun maxProfit_(prices: IntArray): Int {
        val size = prices.size
        if (size < 2)
            return 0

        var buy = -prices[0]
        var sell = 0
        for (p in 1 until size) {
            val prevBuy = buy
            val prevSell = sell
            buy = maxOf(prevBuy, prevSell - prices[p])
            sell = maxOf(prevSell, prevBuy + prices[p])
        }

        return sell
    }
}