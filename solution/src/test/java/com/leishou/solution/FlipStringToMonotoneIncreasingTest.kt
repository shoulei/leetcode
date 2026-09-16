package com.leishou.solution

import org.junit.Test
import kotlin.test.assertEquals

class FlipStringToMonotoneIncreasingTest {
    @Test
    fun testExample1() {
        assertEquals(1, FlipStringToMonotoneIncreasing().minFlipsMonoIncr("00110"))
    }

    @Test
    fun testExample2() {
        assertEquals(2, FlipStringToMonotoneIncreasing().minFlipsMonoIncr("010110"))
    }

    @Test
    fun testExample3() {
        assertEquals(2, FlipStringToMonotoneIncreasing().minFlipsMonoIncr("00011000"))
    }

    @Test
    fun testExample4() {
        assertEquals(1, FlipStringToMonotoneIncreasing().minFlipsMonoIncr("11011"))
    }

    @Test
    fun testExample5() {
        assertEquals(7, FlipStringToMonotoneIncreasing().minFlipsMonoIncr("111011100100100"))
    }
}