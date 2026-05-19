package com.leishou.solution

import org.junit.Test
import kotlin.test.assertEquals

class BullsAndCowsTest {
    @Test
    fun testExample1() {
        val sol = BullsAndCows()
        val result = sol.getHint("9305", "9012")
        assertEquals("1A1B", result)
    }
}