package com.leishou.solution

import org.junit.Test
import kotlin.test.assertEquals

class JumpGameIITest {
    @Test
    fun testExample1() {
        val sol = JumpGameII()
        assertEquals(2, sol.jump(intArrayOf(2, 3, 1, 1, 4)))
    }

    @Test
    fun testExample2() {
        val sol = JumpGameII()
        assertEquals(2, sol.jump(intArrayOf(2, 3, 0, 1, 4)))
    }
}