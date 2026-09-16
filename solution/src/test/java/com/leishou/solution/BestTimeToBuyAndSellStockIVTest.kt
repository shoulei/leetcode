package com.leishou.solution

import org.junit.Test
import kotlin.test.assertEquals

class BestTimeToBuyAndSellStockIVTest {
    @Test
    fun testExample1() {
        assertEquals(8, BestTimeToBuyAndSellStockIV().maxProfit(intArrayOf(1, 3, 2, 8, 4, 9), 2))
    }

    @Test
    fun testExample2() {
        assertEquals(6, BestTimeToBuyAndSellStockIV().maxProfit(intArrayOf(1, 3, 7, 5, 10, 3), 3))
    }

    @Test
    fun testExample3() {
        assertEquals(0, BestTimeToBuyAndSellStockIV().maxProfit(intArrayOf(9, 5, 2, 1), 1))
    }

    @Test
    fun testExample4() {
        assertEquals(1, BestTimeToBuyAndSellStockIV().maxProfit(intArrayOf(9, 1, 3), 1))
    }
}