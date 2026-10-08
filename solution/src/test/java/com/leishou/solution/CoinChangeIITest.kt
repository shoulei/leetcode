package com.leishou.solution

import org.junit.Test
import kotlin.test.assertEquals

class CoinChangeIITest {
    @Test
    fun testExample1() {
        assertEquals(4, CoinChangeII().change(5, intArrayOf(1, 2, 5)))
    }

    @Test
    fun testExample2() {
        assertEquals(0, CoinChangeII().change(3, intArrayOf(2)))
    }

    @Test
    fun testExample3() {
        assertEquals(1, CoinChangeII().change(10, intArrayOf(10)))
    }
}