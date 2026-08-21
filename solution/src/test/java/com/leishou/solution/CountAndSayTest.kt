package com.leishou.solution

import org.junit.Test
import kotlin.test.assertEquals

class CountAndSayTest {
    @Test
    fun testExample1() {
        val sol = CountAndSay()
        assertEquals("1", sol.countAndSay(1))
    }

    @Test
    fun testExample2() {
        val sol = CountAndSay()
        assertEquals("1211", sol.countAndSay(4))
    }

    @Test
    fun testExample3() {
        val sol = CountAndSay()
        assertEquals("111221", sol.countAndSay(5))
    }
}