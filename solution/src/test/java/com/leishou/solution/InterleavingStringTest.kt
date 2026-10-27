package com.leishou.solution

import org.junit.Test
import kotlin.test.assertEquals

class InterleavingStringTest {
    @Test
    fun testExample1() {
        assertEquals(true, InterleavingString().isInterleave("aabcc", "dbbca", "aadbbcbcac"))
    }
}