package com.leishou.solution

import org.junit.Test
import kotlin.test.assertEquals

class CoinChangeTest {
    @Test
    fun testExample1() {
        val coins = intArrayOf(1, 2, 5)
        assertEquals(3, CoinChange().coinChange(coins, 11))
    }

    @Test
    fun testExample2() {
        val coins = intArrayOf(2)
        assertEquals(-1, CoinChange().coinChange(coins, 3))
    }

    @Test
    fun testExample3() {
        val coins = intArrayOf(1)
        assertEquals(0, CoinChange().coinChange(coins, 0))
    }
}