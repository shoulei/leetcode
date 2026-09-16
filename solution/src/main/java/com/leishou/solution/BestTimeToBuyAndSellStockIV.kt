package com.leishou.solution
/*
    You are given an array prices where prices[i] is the price of a given stock on the ith day,
    and an integer fee representing a transaction fee.
    Find the maximum profit you can achieve. You may complete as many transactions as you like,
    but you need to pay the transaction fee for each transaction.
 */
class BestTimeToBuyAndSellStockIV {
    fun maxProfit(prices: IntArray, fee: Int): Int {
        val size = prices.size
        if (size < 2)
            return 0

        var buy = -prices[0]
        var sell = 0
        for (i in 1 until size) {
            buy = maxOf(buy, sell - prices[i])
            sell = maxOf(sell, buy + prices[i] - fee)
        }

        return sell
    }
}