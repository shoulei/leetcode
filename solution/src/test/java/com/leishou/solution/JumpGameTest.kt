package com.leishou.solution

import org.junit.Test
import kotlin.test.assertEquals

class JumpGameTest {
    @Test
    fun testExample1() {
        val sol = JumpGame()
        assertEquals(sol.canJump(intArrayOf(2, 3, 1, 1, 4)), true)
    }

    @Test
    fun testExample2() {
        val sol = JumpGame()
        assertEquals(sol.canJump(intArrayOf(3, 2, 1, 0, 4)), false)
    }

    @Test
    fun testExample3() {
        val sol = JumpGame()
        assertEquals(sol.canJump(intArrayOf(0)), true)
    }

    @Test
    fun testExample4() {
        val sol = JumpGame()
        assertEquals(sol.canJump(intArrayOf(2, 5, 0 ,0)), true)
    }
}