package com.leishou.solution

import org.junit.Test
import kotlin.test.assertEquals

class BestTimeToBuyAndSellStockIITest {
    @Test
    fun testExample1() {
        assertEquals(7, BestTimeToBuyAndSellStockII().maxProfit(intArrayOf(7, 1, 5, 3, 6, 4)))
    }

    @Test
    fun testExample2() {
        assertEquals(4, BestTimeToBuyAndSellStockII().maxProfit(intArrayOf(1, 2, 3, 4, 5)))
    }

    @Test
    fun testExample3() {
        assertEquals(0, BestTimeToBuyAndSellStockII().maxProfit(intArrayOf(7, 6, 4, 3, 1)))
    }
}