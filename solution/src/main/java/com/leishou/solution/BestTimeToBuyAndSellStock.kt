package com.leishou.solution

/*
    You are given an array prices where prices[i] is the price of a given stock on the ith day.
    You want to maximize your profit by choosing a single day to buy one stock and choosing a
    different day in the future to sell that stock.

    Return the maximum profit you can achieve from this transaction. If you cannot achieve any
    profit, return 0.
 */
class BestTimeToBuyAndSellStock {
        fun maxProfit(prices: IntArray): Int {
            val size = prices.size
            if (size < 2)
                return 0

            var buy = Int.MIN_VALUE
            var sell = Int.MIN_VALUE
            for (p in prices) {
                if (buy < -p) {
                    buy = -p
                }

                val temp = buy + p
                if (temp > sell) {
                    sell = temp
                }
            }

            return sell
        }

    fun maxProfit__(prices: IntArray): Int {
        val size = prices.size
        if (size < 2)
            return 0

        var min = prices[0]
        var maxProfit = 0
        for (i in 1 until size) {
            maxProfit = maxOf(maxProfit, prices[i] - min)
            min = minOf(min, prices[i])
        }

        return maxProfit
    }

    fun maxProfit_(prices: IntArray): Int {
        val size = prices.size
        val monotonicStack = IntArray(size)
        var top = -1
        var maxProfit = 0
        for (i in 0 until size) {
            while (top >= 0 && prices[monotonicStack[top]] > prices[i]) {
                maxProfit = maxOf(maxProfit, prices[monotonicStack[top--]] - prices[monotonicStack[0]])
            }
            monotonicStack[++top] = i
        }

        maxProfit = maxOf(maxProfit, prices[monotonicStack[top]] - prices[monotonicStack[0]])
        return maxProfit
    }
}