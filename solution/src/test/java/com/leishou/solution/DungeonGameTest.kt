package com.leishou.solution

import org.junit.Test
import kotlin.test.assertEquals

class DungeonGameTest {
    @Test
    fun testExample1() {
        assertEquals(7, DungeonGame().calculateMinimumHP(arrayOf(intArrayOf(-2, -3 ,3),
            intArrayOf(-5, -10 ,1), intArrayOf(10, 30 ,-5))))
    }

    @Test
    fun testExample2() {
        assertEquals(1, DungeonGame().calculateMinimumHP(arrayOf(intArrayOf(0))))
    }

    @Test
    fun testExample3() {
        assertEquals(4, DungeonGame().calculateMinimumHP(arrayOf(intArrayOf(-3, 5))))
    }

    @Test
    fun testExample4() {
        assertEquals(1, DungeonGame().calculateMinimumHP(arrayOf(intArrayOf(0, -5), intArrayOf(0, 0))))
    }
}