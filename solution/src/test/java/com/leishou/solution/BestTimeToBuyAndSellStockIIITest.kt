package com.leishou.solution

import org.junit.Test
import kotlin.test.assertEquals

class BestTimeToBuyAndSellStockIIITest {
    @Test
    fun testExample1() {
        assertEquals(6, BestTimeToBuyAndSellStockIII().maxProfit(intArrayOf(3, 3, 5, 0, 0, 3, 1, 4)))
    }

    @Test
    fun testExample2() {
        assertEquals(4, BestTimeToBuyAndSellStockIII().maxProfit(intArrayOf(1, 2, 3, 4, 5)))
    }

    @Test
    fun testExample3() {
        assertEquals(0, BestTimeToBuyAndSellStockIII().maxProfit(intArrayOf(7, 6, 4, 3, 1)))
    }
}