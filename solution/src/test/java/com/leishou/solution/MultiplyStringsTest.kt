package com.leishou.solution

import org.junit.Test
import kotlin.test.assertEquals

class MultiplyStringsTest {
    @Test
    fun testExample1() {
        assertEquals("6", MultiplyStrings().multiply("2", "3"))
    }

    @Test
    fun testExample2() {
        assertEquals("56088", MultiplyStrings().multiply("123", "456"))
    }

    @Test
    fun testExample3() {
        assertEquals("0", MultiplyStrings().multiply("0", "0"))
    }

    @Test
    fun testExample4() {
        assertEquals("891", MultiplyStrings().multiply("9", "99"))
    }
}