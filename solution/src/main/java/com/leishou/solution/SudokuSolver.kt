package com.leishou.solution

class SudokuSolver {
    fun solveSudoku(board: Array<CharArray>): Unit {
        val length = board.size
        val total = length * length
        val smallCellLen = 3
        val dataArray: Array<MutableSet<Char>> = Array(total) { hashSetOf() }
        val flatBoard = board.flatMap { it.asIterable() }.toCharArray() // use flat array for deep copy

        fun update(i: Int, j: Int, char: Char): Boolean {
            for (index in 0 until length) {
                if (index != j) {
                    val key = getIndex(i, index, length)
                    val c = flatBoard[key]
                    if (c == char) {
                        return false
                    } else if (c == '.') {
                        dataArray[key].remove(char)
                        if (dataArray[key].size == 1) {
                            val remain = dataArray[key].first()
                            flatBoard[key] = remain
                            if (!update(i, index, remain))
                                return false
                        }
                    }
                }

                if (index != i) {
                    val key = getIndex(index, j, length)
                    val c = flatBoard[key]
                    if (c == char) {
                        return false
                    } else if (c == '.') {
                        dataArray[key].remove(char)
                        if (dataArray[key].size == 1) {
                            val remain = dataArray[key].first()
                            flatBoard[key] = remain
                            if (!update(index, j, remain))
                                return false
                        }
                    }
                }
            }

            val topLeftX = i / smallCellLen
            val topLeftY = j / smallCellLen
            for (si in 0 until smallCellLen) {
                val adjustX = topLeftX * smallCellLen + si
                for (sj in 0 until smallCellLen) {
                    val adjustY = topLeftY * smallCellLen + sj
                    if (i != adjustX && j != adjustY) {
                        val key = getIndex(adjustX, adjustY, length)
                        val c = flatBoard[key]
                        if (c == char) {
                            return false
                        } else if (c == '.') {
                            dataArray[key].remove(char)
                            if (dataArray[key].size == 1) {
                                val remain = dataArray[key].first()
                                flatBoard[key] = remain
                                if (!update(adjustX, adjustY, remain))
                                    return false
                            }
                        }
                    }
                }
            }

            return true
        }

        fun checkAndUpdate(i: Int, j: Int): Boolean {
            val hostKey = getIndex(i, j, length)
            for (index in 0 until length) {
                var key = getIndex(i, index, length)
                var c = flatBoard[key]
                if (c != '.' && index != j) {
                    dataArray[hostKey].remove(c)
                }

                key = getIndex(index, j, length)
                c = flatBoard[key]
                if (c != '.' && index != i) {
                    dataArray[hostKey].remove(c)
                }
            }

            val topLeftX = i / smallCellLen
            val topLeftY = j / smallCellLen
            for (si in 0 until smallCellLen) {
                val adjustX = topLeftX * smallCellLen + si
                for (sj in 0 until smallCellLen) {
                    val adjustY = topLeftY * smallCellLen + sj
                    val key = getIndex(adjustX, adjustY, length)
                    val c = flatBoard[key]
                    if (c != '.' && adjustX != i && adjustY != j) {
                        dataArray[hostKey].remove(c)
                    }
                }
            }

            if (dataArray[hostKey].size == 1 && flatBoard[hostKey] == '.') {
                val c = dataArray[hostKey].first()
                flatBoard[hostKey] = c
                return update(i, j, c)
            }

            return true
        }

        fun dfs(key: Int): Boolean {
            if (key == total - 1) {
                return true
            }

            val i = key / length
            val j = key % length
            val setCopy = HashSet(dataArray[key])
            val dataArrayCopy = Array(dataArray.size) { index -> dataArray[index].toMutableSet() }
            if (setCopy.size == 1) {
                return dfs(key + 1)
            } else if (setCopy.size > 1) {
                for (c in setCopy) {
                    val tempArray = flatBoard.copyOf()
                    flatBoard[key] = c
                    if (!update(i, j, c)) {
                        dataArray.forEachIndexed { index, chars ->
                            chars.apply {
                                clear()
                                addAll(dataArrayCopy[index])
                            }
                        }

                        tempArray.copyInto(flatBoard)
                        continue
                    }

                    if (dfs(key + 1)) {
                        return true
                    }

                    dataArray.forEachIndexed { index, chars ->
                        chars.apply {
                            clear()
                            addAll(dataArrayCopy[index])
                        }
                    }
                    tempArray.copyInto(flatBoard)
                }
            } else {
                return false
            }

            return false
        }

        for (i in 0 until length) {
            for (j in 0 until length) {
                when (board[i][j]) {
                    '.' -> {
                        dataArray[getIndex(i, j, length)] =
                                hashSetOf('1', '2', '3', '4', '5', '6', '7', '8', '9')
                    }

                    else -> {
                        dataArray[getIndex(i, j, length)] = hashSetOf(board[i][j])
                    }
                }
            }
        }

        for (i in 0 until length) {
            for (j in 0 until length) {
                when (board[i][j]) {
                    '.' -> {
                        checkAndUpdate(i, j)
                    }

                    else -> {
                        // do nothing
                    }
                }
            }
        }

        val ret = dfs(0)
        if (ret) {
            for (key in 0 until total) {
                val i = key / length
                val j = key % length
                board[i][j] = flatBoard[key]
            }
        }
    }

    private fun getIndex(i: Int, j: Int, size: Int) = i * size + j
}