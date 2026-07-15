package com.leishou.solution

import org.junit.Test
import kotlin.test.assertContentEquals

class NQueensTest {
    @Test
    fun testExample1() {
        val sol = NQueens()
        val ret = sol.solveNQueens(4)
        assertContentEquals(ret, listOf(listOf(".Q..", "...Q", "Q...", "..Q."), listOf("..Q.", "Q...", "...Q", ".Q..")))
    }

    @Test
    fun testExample2() {
        val sol = NQueens()
        val ret = sol.solveNQueens(1)
        assertContentEquals(ret, listOf(listOf("Q")))
    }
}