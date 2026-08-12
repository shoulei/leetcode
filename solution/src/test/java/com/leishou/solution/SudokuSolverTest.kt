package com.leishou.solution

import org.junit.Test
import kotlin.test.assertEquals

class SudokuSolverTest {
    @Test
    fun testExample1() {
        val sol = SudokuSolver()
        val array = arrayOf(
            charArrayOf('5', '3', '.', '.', '7', '.', '.', '.', '.'),
            charArrayOf('6', '.', '.', '1', '9', '5', '.', '.', '.'),
            charArrayOf('.', '9', '8', '.', '.', '.', '.', '6', '.'),
            charArrayOf('8', '.', '.', '.', '6', '.', '.', '.', '3'),
            charArrayOf('4', '.', '.', '8', '.', '3', '.', '.', '1'),
            charArrayOf('7', '.', '.', '.', '2', '.', '.', '.', '6'),
            charArrayOf('.', '6', '.', '.', '.', '.', '2', '8', '.'),
            charArrayOf('.', '.', '.', '4', '1', '9', '.', '.', '5'),
            charArrayOf('.', '.', '.', '.', '8', '.', '.', '7', '9')
        )
        sol.solveSudoku(array)

        val expectedList = arrayOf(
            charArrayOf('5', '3', '4', '6', '7', '8', '9', '1', '2'),
            charArrayOf('6', '7', '2', '1', '9', '5', '3', '4', '8'),
            charArrayOf('1', '9', '8', '3', '4', '2', '5', '6', '7'),
            charArrayOf('8', '5', '9', '7', '6', '1', '4', '2', '3'),
            charArrayOf('4', '2', '6', '8', '5', '3', '7', '9', '1'),
            charArrayOf('7', '1', '3', '9', '2', '4', '8', '5', '6'),
            charArrayOf('9', '6', '1', '5', '3', '7', '2', '8', '4'),
            charArrayOf('2', '8', '7', '4', '1', '9', '6', '3', '5'),
            charArrayOf('3', '4', '5', '2', '8', '6', '1', '7', '9')
        ).map { it.toList() }

        assertEquals(expectedList, array.map { it.toList() })
    }

    @Test
    fun testExample2() {
        val sol = SudokuSolver()
        val array = arrayOf(
            charArrayOf('.', '.', '9', '7', '4', '8', '.', '.', '.'),
            charArrayOf('7', '.', '.', '.', '.', '.', '.', '.', '.'),
            charArrayOf('.', '2', '.', '1', '.', '9', '.', '.', '.'),
            charArrayOf('.', '.', '7', '.', '.', '.', '2', '4', '.'),
            charArrayOf('.', '6', '4', '.', '1', '.', '5', '9', '.'),
            charArrayOf('.', '9', '8', '.', '.', '.', '3', '.', '.'),
            charArrayOf('.', '.', '.', '8', '.', '3', '.', '2', '.'),
            charArrayOf('.', '.', '.', '.', '.', '.', '.', '.', '6'),
            charArrayOf('.', '.', '.', '2', '7', '5', '9', '.', '.')
        )
        sol.solveSudoku(array)

        val expectedList = arrayOf(
            charArrayOf('5', '1', '9', '7', '4', '8', '6', '3', '2'),
            charArrayOf('7', '8', '3', '6', '5', '2', '4', '1', '9'),
            charArrayOf('4', '2', '6', '1', '3', '9', '8', '7', '5'),
            charArrayOf('3', '5', '7', '9', '8', '6', '2', '4', '1'),
            charArrayOf('2', '6', '4', '3', '1', '7', '5', '9', '8'),
            charArrayOf('1', '9', '8', '5', '2', '4', '3', '6', '7'),
            charArrayOf('9', '7', '5', '8', '6', '3', '1', '2', '4'),
            charArrayOf('8', '3', '2', '4', '9', '1', '7', '5', '6'),
            charArrayOf('6', '4', '1', '2', '7', '5', '9', '8', '3')
        ).map { it.toList() }

        assertEquals(expectedList, array.map { it.toList() })
    }

    @Test
    fun testExample3() {
        val sol = SudokuSolver()
        val array = arrayOf(
            charArrayOf('.', '.', '.', '2', '.', '.', '.', '6', '3'),
            charArrayOf('3', '.', '.', '.', '.', '5', '4', '.', '1'),
            charArrayOf('.', '.', '1', '.', '.', '3', '9', '8', '.'),
            charArrayOf('.', '.', '.', '.', '.', '.', '.', '9', '.'),
            charArrayOf('.', '.', '.', '5', '3', '8', '.', '.', '.'),
            charArrayOf('.', '3', '.', '.', '.', '.', '.', '.', '.'),
            charArrayOf('.', '2', '6', '3', '.', '.', '5', '.', '.'),
            charArrayOf('5', '.', '3', '7', '.', '.', '.', '.', '8'),
            charArrayOf('4', '7', '.', '.', '.', '1', '.', '.', '.')
        )
        sol.solveSudoku(array)

        val expectedList = arrayOf(
            charArrayOf('8', '5', '4', '2', '1', '9', '7', '6', '3'),
            charArrayOf('3', '9', '7', '8', '6', '5', '4', '2', '1'),
            charArrayOf('2', '6', '1', '4', '7', '3', '9', '8', '5'),
            charArrayOf('7', '8', '5', '1', '2', '6', '3', '9', '4'),
            charArrayOf('6', '4', '9', '5', '3', '8', '1', '7', '2'),
            charArrayOf('1', '3', '2', '9', '4', '7', '8', '5', '6'),
            charArrayOf('9', '2', '6', '3', '8', '4', '5', '1', '7'),
            charArrayOf('5', '1', '3', '7', '9', '2', '6', '4', '8'),
            charArrayOf('4', '7', '8', '6', '5', '1', '2', '3', '9')
        ).map { it.toList() }

        assertEquals(expectedList, array.map { it.toList() })
    }
}
