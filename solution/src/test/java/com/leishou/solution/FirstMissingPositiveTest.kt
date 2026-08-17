package com.leishou.solution

import org.junit.Test
import kotlin.test.assertEquals

class FirstMissingPositiveTest {
    @Test
    fun testExample1() {
        val sol = FirstMissingPositive()
        assertEquals(10, sol.firstMissingPositive(intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9)))
    }

    @Test
    fun testExample2() {
        val sol = FirstMissingPositive()
        assertEquals(5, sol.firstMissingPositive(intArrayOf(-10, 1, 2, 2, 3, 4, 6, 6, 8)))
    }

    @Test
    fun testExample3() {
        val sol = FirstMissingPositive()
        assertEquals(3, sol.firstMissingPositive(intArrayOf(1, 2, 0)))
    }

    @Test
    fun testExample4() {
        val sol = FirstMissingPositive()
        assertEquals(2, sol.firstMissingPositive(intArrayOf(3, 4, -1, 1)))
    }

    @Test
    fun testExample5() {
        val sol = FirstMissingPositive()
        assertEquals(1, sol.firstMissingPositive(intArrayOf(7, 8, 9, 11, 12)))
    }

    @Test
    fun testExample6() {
        val sol = FirstMissingPositive()
        assertEquals(5, sol.firstMissingPositive(intArrayOf(4, 1, 2, 3)))
    }
}