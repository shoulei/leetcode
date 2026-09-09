package com.leishou.solution

import org.junit.Test
import kotlin.test.assertEquals

class SelfCrossingTest {
    @Test
    fun testExample1() {
        val sol = SelfCrossing()
        assertEquals(true, sol.isSelfCrossing(intArrayOf(2, 1, 1, 2)))
    }

    @Test
    fun testExample2() {
        val sol = SelfCrossing()
        assertEquals(false, sol.isSelfCrossing(intArrayOf(1, 2, 3, 4)))
    }

    @Test
    fun testExample3() {
        val sol = SelfCrossing()
        assertEquals(true, sol.isSelfCrossing(intArrayOf(1, 1, 1, 2, 1)))
    }

    @Test
    fun testExample4() {
        val sol = SelfCrossing()
        assertEquals(true, sol.isSelfCrossing(intArrayOf(1, 1, 1, 1)))
    }

    @Test
    fun testExample5() {
        val sol = SelfCrossing()
        assertEquals(true, sol.isSelfCrossing(intArrayOf(1, 1, 2, 1, 1)))
    }
}