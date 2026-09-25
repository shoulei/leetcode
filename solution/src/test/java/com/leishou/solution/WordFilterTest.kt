package com.leishou.solution

import org.junit.Test
import kotlin.test.assertEquals

class WordFilterTest {
    @Test
    fun testExample1() {
        val wordFilter = WordFilter(arrayOf("apple"))
        assertEquals(0, wordFilter.f("a", "e"))
    }
}