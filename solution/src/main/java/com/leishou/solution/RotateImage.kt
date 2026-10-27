package com.leishou.solution

/*
    You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).

    You have to rotate the image in-place, which means you have to modify the input 2D matrix directly.
    DO NOT allocate another 2D matrix and do the rotation.

    n == matrix.length == matrix[i].length
    1 <= n <= 20
    -1000 <= matrix[i][j] <= 1000
 */
class RotateImage {
    fun rotate(matrix: Array<IntArray>) {
        val n = matrix.size
        var first = 0
        var last = n - 1
        while (first < last) {
            for (i in first until last) {
                var row = first
                var col = i
                var mid = matrix[row][col]
                repeat (4) {
                    val nextRow: Int
                    val nextCol: Int
                    when (row) {
                        first -> {
                            nextRow = col
                            nextCol = last
                        }

                        last -> {
                            nextRow = col
                            nextCol = first
                        }

                        else -> {
                            if (col == first) {
                                nextRow = first
                                nextCol = last - row + first
                            } else {
                                nextRow = last
                                nextCol = last - row + first
                            }
                        }
                    }

                    val temp = matrix[nextRow][nextCol]
                    matrix[nextRow][nextCol] = mid
                    mid = temp

                    col = nextCol
                    row = nextRow
                }
            }

            first++
            last--
        }
    }
}