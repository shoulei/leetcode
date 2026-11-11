package com.leishou.solution

/*
    Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.
    You must do it in place.

    m == matrix.length
    n == matrix[0].length
    1 <= m, n <= 200
    -2^31 <= matrix[i][j] <= 2^31 - 1
 */
class SetMatrixZeroes {
    fun setZeroes(matrix: Array<IntArray>): Unit {
        if (matrix.isEmpty())
            return

        val row = matrix.size
        val col = matrix[0].size
        var isTopAllZero = false
        var isLeftAllZero = false
        for (i in 0 until row) {
            for (j in 0 until col) {
                if (matrix[i][j] == 0) {
                    if (i != 0 && j != 0) {
                        matrix[i][0] = 0
                        matrix[0][j] = 0
                    } else {
                        if (i == 0) {
                            isTopAllZero = true
                        }
                        if (j == 0) {
                            isLeftAllZero = true
                        }
                    }
                }
            }
        }

        for (i in  1 until row) {
            if (matrix[i][0] == 0) {
                for (j in matrix[0].indices) {
                    matrix[i][j] = 0
                }
            }
        }

        for (j in 1 until col) {
            if (matrix[0][j] == 0) {
                for (i in matrix.indices) {
                    matrix[i][j] = 0
                }
            }
        }

        if (isTopAllZero) {
            for (j in 0 until col) {
                matrix[0][j] = 0
            }
        }

        if (isLeftAllZero) {
            for (i in  0 until row) {
                matrix[i][0] = 0
            }
        }
    }
}