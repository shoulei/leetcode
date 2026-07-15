package com.leishou.solution

class NQueens {
    fun solveNQueens(n: Int): List<List<String>> {
        val col = IntArray(n) { -1 }
        val diag0 = BooleanArray(n) { false } // |
        val diag1 = BooleanArray(n * 2) { false } // \
        val diag2 = BooleanArray(n * 2) { false } // /
        val ret = mutableListOf<List<String>>()
        fun dfs(row: Int) {
            if (row == n) {
                ret.add(arrayToListString(col, n))
                return
            }

            for (i in 0 until n) {
                if (diag0[i] || diag1[row - i + n] || diag2[row + i])
                    continue
                diag0[i] = true
                diag1[row - i + n] = true
                diag2[row + i] = true
                col[row] = i
                dfs(row + 1)
                col[row] = -1
                diag0[i] = false
                diag1[row - i + n] = false
                diag2[row + i] = false
            }
        }

        dfs(0)

        return ret
    }

    //private fun Int.setBit(n: Int): Int = this or (1 shl n)
    //private fun Int.clearBit(n: Int): Int = this and (1 shl n).inv()
    //private fun Int.isBitSet(n: Int): Boolean = (this and (1 shl n)) != 0

    private fun arrayToListString(array: IntArray, size: Int): List<String> {
        val ret = mutableListOf<String>()
        for (i in 0 until size) {
            val string = CharArray(size) { '.' }
            val data = array[i]
            string[data] = 'Q'
            ret.add(String(string))
        }

        return ret
    }
}