package com.leishou.solution

import org.junit.Test
import kotlin.test.assertEquals

class BestTimeToBuyAndSellStockTest {
    @Test
    fun testExample1() {
        assertEquals(5, BestTimeToBuyAndSellStock().maxProfit(intArrayOf(7, 1, 5, 3, 6, 4)))
    }

    @Test
    fun testExample2() {
        assertEquals(0, BestTimeToBuyAndSellStock().maxProfit(intArrayOf(7, 6, 4, 3, 1)))
    }

    @Test
    fun testExample3() {
        assertEquals(2, BestTimeToBuyAndSellStock().maxProfit(intArrayOf(2, 4, 1)))
    }

    @Test
    fun testExample4() {
        assertEquals(1, BestTimeToBuyAndSellStock().maxProfit(intArrayOf(1, 2)))
    }
}