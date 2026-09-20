package com.leishou.solution

import org.junit.Test
import kotlin.test.assertEquals

class BurstBalloonsTest {
    @Test
    fun testExample1() {
        val sol = BurstBalloons()
        assertEquals(167, sol.maxCoins(intArrayOf(3, 1, 5, 8)))
    }

    @Test
    fun testExample2() {
        val sol = BurstBalloons()
        assertEquals(10, sol.maxCoins(intArrayOf(1, 5)))
    }

    @Test
    fun testExample3() {
        val sol = BurstBalloons()
        assertEquals(116718, sol.maxCoins(intArrayOf(9, 76, 64, 21)))
    }
}