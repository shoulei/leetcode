package com.leishou.solution

/*
    Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according
    to the following rules:
    1, Each row must contain the digits 1-9 without repetition.
    2, Each column must contain the digits 1-9 without repetition.
    3, Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.

    Note:
    1, A Sudoku board (partially filled) could be valid but is not necessarily solvable.
    2, Only the filled cells need to be validated according to the mentioned rules.
 */
class ValidSudoku {
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        val n = board.size
        var rowMask: Int
        var colMask: Int
        var boxMask: Int
        for (i in 0 until n) {
            rowMask = 0
            colMask = 0
            boxMask = 0
            for (j in 0 until n) {
                val rowData = board[i][j]
                if (rowData != '.') {
                    val rowBit = charToInt(rowData)
                    if (rowMask and rowBit != 0) {
                        return false
                    }
                    rowMask = rowMask or rowBit
                }

                val colData = board[j][i]
                if (colData != '.') {
                    val colBit = charToInt(colData)
                    if (colMask and colBit != 0) {
                        return false
                    }
                    colMask = colMask or colBit
                }

                val cellX = (i / 3) * 3 + j / 3
                val cellY = (i % 3) * 3 + j % 3
                val boxData = board[cellX][cellY]
                if (boxData != '.') {
                    val boxBit = charToInt(boxData)
                    if (boxMask and boxBit != 0) {
                        return false
                    }
                    boxMask = boxMask or boxBit
                }
            }
        }

        return true
    }

    private fun charToInt(c: Char) = 1 shl (c.digitToInt() - 1)
}