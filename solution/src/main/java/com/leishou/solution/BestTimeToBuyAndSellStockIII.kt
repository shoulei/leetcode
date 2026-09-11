package com.leishou.solution

/*
    You are given an array prices where prices[i] is the price of a given stock on the ith day.
    Find the maximum profit you can achieve. You may complete at most two transactions.
    Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock
    before you buy again).
 */
class BestTimeToBuyAndSellStockIII {
    fun maxProfit(prices: IntArray): Int {
        var buy1 = Int.MIN_VALUE
        var sell1 = Int.MIN_VALUE
        var buy2 = Int.MIN_VALUE
        var sell2 = Int.MIN_VALUE
        for (p in prices) {
            buy1 = maxOf(buy1, -p)
            sell1 = maxOf(sell1, buy1 + p)
            buy2 = maxOf(buy2, sell1 - p)
            sell2 = maxOf(sell2, buy2 + p)
        }

        return sell2
    }
}