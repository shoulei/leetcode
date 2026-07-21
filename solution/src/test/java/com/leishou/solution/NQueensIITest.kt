package com.leishou.solution

import org.junit.Test
import kotlin.test.assertEquals

class NQueensIITest {
    @Test
    fun testExample1() {
        val sol = NQueensII()
        assertEquals(sol.totalNQueens(1), 1)
    }

    @Test
    fun testExample2() {
        val sol = NQueensII()
        assertEquals(sol.totalNQueens(4), 2)
    }

    @Test
    fun testExample3() {
        val sol = NQueensII()
        assertEquals(sol.totalNQueens(2), 0)
    }
}