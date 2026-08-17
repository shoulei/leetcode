package com.leishou.solution

class SudokuSolver {
    fun solveSudoku(board: Array<CharArray>): Unit {
        val BIT_MASK = 0x1FF // 0b11111111, each bit stands for 1 number
        val length = board.size
        val total = length * length
        val smallCellLen = 3

        val rows = IntArray(length) { 0 } // appeared char
        val cols = IntArray(length) { 0 }
        val boxes = IntArray(length * length / (smallCellLen * smallCellLen)) { 0 }
        val boardData = IntArray(total) { BIT_MASK }
        val boxesInRow = length / smallCellLen

        // bitData should has exactly one bit set to 1
        fun updateMasks(i: Int, j: Int, bitData: Int): Boolean {
            val box = i / smallCellLen * boxesInRow + j / smallCellLen
            val ret = (rows[i].inv() and bitData != 0) && (cols[j].inv() and bitData != 0) && (boxes[box].inv() and bitData != 0)
            rows[i] = rows[i] or bitData
            cols[j] = cols[j] or bitData
            boxes[box] = boxes[box] or bitData
            return ret
        }

        // bitData should has exactly one bit set to 1
        fun update(i: Int, j: Int, bitData: Int): Boolean {
            val bitCt = Integer.bitCount(bitData)
            if (bitCt == 0) {
                return false
            } else if (bitCt > 1) {
                return true
            }

            if (updateMasks(i, j, bitData)) {
                for (index in 0 until length) {
                    if (index != j) {
                        val sameRow = i * length + index
                        if (boardData[sameRow] == bitData) {
                            return false
                        } else if (Integer.bitCount(boardData[sameRow]) > 1) {
                            boardData[sameRow] = boardData[sameRow] and rows[i].inv()
                            if (!update(i, index, boardData[sameRow]))
                                return false
                        }
                    }

                    if (index != i) {
                        val sameCol = index * length + j
                        if (boardData[sameCol] == bitData) {
                            return false
                        } else if (Integer.bitCount(boardData[sameCol]) > 1) {
                            boardData[sameCol] = boardData[sameCol] and cols[j].inv()
                            if (!update(index, j, boardData[sameCol]))
                                return false
                        }
                    }
                }

                val topLeftX = i / smallCellLen
                val topLeftY = j / smallCellLen
                val box = topLeftX * boxesInRow + topLeftY
                for (si in 0 until smallCellLen) {
                    val adjustX = topLeftX * smallCellLen + si
                    for (sj in 0 until smallCellLen) {
                        val adjustY = topLeftY * smallCellLen + sj
                        // Only process box peers that are not already covered by row/col propagation
                        if (i != adjustX && j != adjustY) {
                            val sameBox = adjustX * length + adjustY
                            if (boardData[sameBox] == bitData) {
                                return false
                            } else if (Integer.bitCount(boardData[sameBox]) > 1) {
                                boardData[sameBox] = boardData[sameBox] and boxes[box].inv()
                                if (!update(adjustX, adjustY, boardData[sameBox]))
                                    return false
                            }
                        }
                    }
                }

                return true
            }

            return false
        }

        fun propagate() {
            for (i in 0 until length) {
                val baseIndex = i * length
                for (j in 0 until length) {
                    if (board[i][j] == '.') {
                        val box = i / smallCellLen * boxesInRow + j / smallCellLen
                        val data = boardData[baseIndex + j]
                        boardData[baseIndex + j] =
                            data and rows[i].inv() and cols[j].inv() and boxes[box].inv()
                    }
                }
            }
        }

        fun dfs(): Boolean {
            var minCtCell = -1
            var minCt = Int.MAX_VALUE
            for (i in 0 until total) {
                if (boardData[i] == 0) {
                    return false
                }

                val bitCt = Integer.bitCount(boardData[i])
                if (bitCt in 2..< minCt) {
                    minCtCell = i
                    minCt = bitCt
                }
            }

            if (minCtCell == -1)
                return true

            val rowsCopy = rows.clone()
            val colsCopy = cols.clone()
            val boxesCopy = boxes.clone()
            val boardDataCopy = boardData.clone()
            var candidate = boardDataCopy[minCtCell]
            val row = minCtCell / length
            val col = minCtCell % length
            while (candidate != 0) {
                val bitData = candidate and -candidate
                boardData[minCtCell] = bitData
                if (update(row, col, bitData)) {
                    if (dfs())
                        return true
                }

                rowsCopy.copyInto(rows)
                colsCopy.copyInto(cols)
                boxesCopy.copyInto(boxes)
                boardDataCopy.copyInto(boardData)
                candidate -= bitData
            }

            return false
        }

        for (i in 0 until length) {
            for (j in 0 until length) {
                val key = i * length + j
                if (board[i][j] != '.') {
                    val boardBit = charToInt(board[i][j])
                    updateMasks(i, j, boardBit)
                    boardData[key] = boardBit
                }
            }
        }

        propagate()
        if (dfs()) {
            for (key in 0 until total) {
                val i = key / length
                val j = key % length
                board[i][j] = intToChar(boardData[key])
            }
        }
    }

    // 0b10 -> '2'
    private fun intToChar(candidate: Int) = (Integer.numberOfTrailingZeros(candidate) + 1).digitToChar()
    // '2' -> 0b10
    private fun charToInt(c: Char) = 1 shl (c.digitToInt() - 1)
}