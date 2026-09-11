package com.leishou.solution

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