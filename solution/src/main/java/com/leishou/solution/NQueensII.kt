package com.leishou.solution

class NQueensII {
    fun totalNQueens(n: Int): Int {
        val cols = BooleanArray(n) { false }
        val dig1 = BooleanArray(n * 2) { false }
        val dig2 = BooleanArray(n * 2) { false }
        var count = 0
        fun dfs(row: Int) {
            if (row >= n) {
                count++
                return
            }

            for (i in 0 until n) {
                if (cols[i] || dig1[i + row] || dig2[i - row + n])
                    continue

                cols[i] = true
                dig1[i + row] = true
                dig2[i - row + n] = true
                dfs(row + 1)
                cols[i] = false
                dig1[i + row] = false
                dig2[i - row + n] = false
            }
        }

        dfs(0)
        return count
    }
}