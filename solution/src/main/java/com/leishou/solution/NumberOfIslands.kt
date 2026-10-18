package com.leishou.solution

import java.util.BitSet

/*
    Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water),
    return the number of islands.
    An island is surrounded by water and is formed by connecting adjacent lands horizontally or
    vertically. You may assume all four edges of the grid are all surrounded by water.

    m == grid.length
    n == grid[i].length
    1 <= m, n <= 300
    grid[i][j] is '0' or '1'.
 */
class NumberOfIslands {
    fun numIslands(grid: Array<CharArray>): Int {
        val m = grid.size
        val n = grid[0].size

        fun traversal(x: Int, y: Int) {
            if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] == '0')
                return

            grid[x][y] = '0'
            traversal(x + 1, y)
            traversal(x - 1, y)
            traversal(x, y + 1)
            traversal(x, y - 1)
        }

        var result = 0
        for (i in 0 until m) {
            for (j in 0 until n) {
                if (grid[i][j] == '1') {
                    traversal(i, j)
                    result++
                }
            }
        }

        return result
    }
}