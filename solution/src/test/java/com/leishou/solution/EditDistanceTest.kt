package com.leishou.solution

import org.junit.Test
import kotlin.test.assertEquals

class EditDistanceTest {
    @Test
    fun testExample1() {
        assertEquals(5, EditDistance().minDistance("intention", "execution"))
    }

    @Test
    fun testExample2() {
        assertEquals(3, EditDistance().minDistance("horse", "ros"))
    }

    @Test
    fun testExample3() {
        assertEquals(2, EditDistance().minDistance("sea", "eat"))
    }
}