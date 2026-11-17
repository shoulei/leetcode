package com.leishou.solution

/*
    You are given an m x n integer matrix matrix with the following two properties:
    1, Each row is sorted in non-decreasing order.
    2, The first integer of each row is greater than the last integer of the previous row.
    Given an integer target, return true if target is in matrix or false otherwise.

    You must write a solution in O(log(m * n)) time complexity.

    m == matrix.length
    n == matrix[i].length
    1 <= m, n <= 100
    -10^4 <= matrix[i][j], target <= 10^4
 */
class SearchA2dMatrix {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        if (matrix.isEmpty())
            return false

        val m = matrix.size
        val n = matrix[0].size
        var top = 0
        var bottom = m - 1
        var left = 0
        var right = n - 1
        while (top < bottom - 1) {
            val half = (top + bottom) shr 1
            if (matrix[half][0] > target) {
                bottom = half
            } else if (matrix[half][0] < target) {
                top = half
            } else {
                return true
            }
        }

        if (matrix[bottom][0] < target) {
            top = bottom
        } else if (matrix[bottom][0] == target) {
            return true
        }

        while (left < right - 1) {
            val mid = (left + right) shr 1
            if (matrix[top][mid] > target) {
                right = mid
            } else if (matrix[top][mid] < target) {
                left = mid
            } else {
                return true
            }
        }

        return matrix[top][left] == target || matrix[top][right] == target
    }
}