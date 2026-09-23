package com.leishou.solution

import org.junit.Test
import kotlin.test.assertEquals

class ValidNumberTest {
    @Test
    fun testExample1() {
        val sol = ValidNumber()
        assertEquals(true, sol.isNumber("0"))
    }

    @Test
    fun testExample2() {
        val sol = ValidNumber()
        assertEquals(false, sol.isNumber("e"))
    }

    @Test
    fun testExample3() {
        val sol = ValidNumber()
        assertEquals(false, sol.isNumber("."))
    }

    @Test
    fun testExample4() {
        val sol = ValidNumber()
        assertEquals(true, sol.isNumber("-123.456e789"))
    }

    @Test
    fun testExample5() {
        val sol = ValidNumber()
        assertEquals(false, sol.isNumber("+."))
    }

    @Test
    fun testExample6() {
        val sol = ValidNumber()
        assertEquals(false, sol.isNumber("0e"))
    }

    @Test
    fun testExample7() {
        val sol = ValidNumber()
        assertEquals(true, sol.isNumber("46.e3"))
    }

    @Test
    fun testExample8() {
        val sol = ValidNumber()
        assertEquals(false, sol.isNumber("-.E3"))
    }
}