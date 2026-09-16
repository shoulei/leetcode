package com.leishou.solution

import org.junit.Test
import kotlin.test.assertEquals

class HouseRobberTest {
    @Test
    fun testExample1() {
        assertEquals(4, HouseRobber().rob(intArrayOf(1, 2, 3, 1)))
    }

    @Test
    fun testExample2() {
        assertEquals(12, HouseRobber().rob(intArrayOf(2, 7, 9, 3, 1)))
    }
}