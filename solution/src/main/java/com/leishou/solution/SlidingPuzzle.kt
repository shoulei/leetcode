package com.leishou.solution

/*
    On an 2 x 3 board, there are five tiles labeled from 1 to 5, and an empty square represented
    by 0. A move consists of choosing 0 and a 4-directionally adjacent number and swapping it.

    The state of the board is solved if and only if the board is [[1,2,3],[4,5,0]].

    Given the puzzle board board, return the least number of moves required so that the state of
    the board is solved. If it is impossible for the state of the board to be solved, return -1.

    board.length == 2
    board[i].length == 3
    0 <= board[i][j] <= 5
    Each value board[i][j] is unique.
 */
class SlidingPuzzle {
    fun slidingPuzzle(board: Array<IntArray>): Int {
        var startBitData = 0
        var shift = 0
        for (i in board.indices) {
            for (j in board[0].indices) {
                startBitData = startBitData or (board[i][j] shl shift)
                shift += 3
            }
        }

        val targetBitData = 1 or (2 shl 3) or (3 shl 6) or (4 shl 9) or (5 shl 12)
        if (startBitData == targetBitData)
            return 0

        // Each cell is represented using 3 bits, which can encode values from 0 to 7.
        // Since the puzzle contains numbers from 0 to 5, 3 bits per cell are sufficient.
        // With 6 cells, we need only 18 bits in total, which fits within a 32-bit Int.
        val visited = hashSetOf<Int>()
        // availableSwap, for example, cell 0 - left top cell, can swap with cell 1 and cell 3,
        // so availableSwap[0] = intArray(1, 3)
        val availableSwap = arrayOf (
            intArrayOf(1, 3),
            intArrayOf(0, 2, 4),
            intArrayOf(1, 5),
            intArrayOf(0, 4),
            intArrayOf(1, 3, 5),
            intArrayOf(2, 4)
        )

        var step = 0
        var startList = mutableListOf(startBitData)
        var endList = mutableListOf(targetBitData)
        var isStartExpanding: Boolean
        visited.add(startBitData)
        visited.add(targetBitData)
        while (startList.isNotEmpty() && endList.isNotEmpty()) {
            step++
            isStartExpanding = startList.size < endList.size
            val expandingList = if (isStartExpanding) startList else endList
            val comparedList = if (isStartExpanding) endList else startList
            val compareSet = comparedList.toSet()

            val nextList = mutableListOf<Int>()
            for (bitData in expandingList) {
                val index = indexOfZero(bitData)
                if (index < 0)
                    continue
                for (swapIndex in availableSwap[index]) {
                    val newBit = swap(bitData, index, swapIndex)
                    if (newBit in compareSet) {
                        return step
                    }

                    if (visited.add(newBit)) {
                        nextList.add(newBit)
                    }
                }
            }

            if (isStartExpanding) {
                startList = nextList
            } else {
                endList = nextList
            }
        }

        return -1
    }

    private fun indexOfZero(bitData: Int): Int {
        for (i in 0 until 6) {
            if (((bitData shr (i * 3)) and 7) == 0) {
                return i
            }
        }

        return -1
    }

    private fun swap(bitData: Int, from: Int, to: Int): Int {
        if (from == to)
            return bitData

        val mask = 7 // 0b111
        val fromShift = from * 3
        val toShift = to * 3
        val fromMask = mask shl fromShift
        val toMask = mask shl toShift
        return (bitData and (fromMask or toMask).inv()) or
                ((bitData and fromMask) shr fromShift shl toShift) or
                ((bitData and toMask) shr toShift shl fromShift)
    }

    // ============== old list solution ===========================

    fun slidingPuzzle_(board: Array<IntArray>): Int {
        val cache = HashMap<List<Int>, Int>()
        var finalStep = 0
        val finalBoard = listOf(1, 2, 3, 4, 5, 0)
        cache[finalBoard] = 0
        val sourceList = intArrayToList(board)
        var originalList = mutableListOf(finalBoard)
        var isExpanding = true
        while (true) {
            if (cache.contains(sourceList))
                return cache[sourceList]!!

            if (!isExpanding)
                break

            finalStep++
            isExpanding = false
            val expandList = mutableListOf<List<Int>>()
            for (source in originalList) {
                for (single in listNeighbours(source)) {
                    if (cache.contains(single))
                        continue

                    cache[single] = finalStep
                    expandList.add(single)
                    isExpanding = true
                }
            }

            originalList = expandList
        }

        return -1
    }

    // only 0 can swap with its neighbours
    private fun listNeighbours(data: List<Int>): List<List<Int>> {
        val ret = mutableListOf<List<Int>>()
        for (i in 0 until 6) {
            if (data[i] != 0)
                continue

            val row = i / 3
            val col = i % 3
            if (row == 0) {
                val copy = data.toMutableList()
                val temp = copy[i + 3]
                copy[i + 3] = data[i]
                copy[i] = temp
                ret.add(copy)
            } else {
                val copy = data.toMutableList()
                val temp = copy[i - 3]
                copy[i - 3] = data[i]
                copy[i] = temp
                ret.add(copy)
            }

            if (col < 2) {
                val copy = data.toMutableList()
                val temp = copy[i + 1]
                copy[i + 1] = data[i]
                copy[i] = temp
                ret.add(copy)
            }

            if (col > 0) {
                val copy = data.toMutableList()
                val temp = copy[i - 1]
                copy[i - 1] = data[i]
                copy[i] = temp
                ret.add(copy)
            }
        }

        return ret
    }

    private fun intArrayToList(data: Array<IntArray>): List<Int> {
        val list = ArrayList<Int>(6)
        for (i in data.indices) {
            for (j in data[0].indices) {
                list.add(data[i][j])
            }
        }

        return list
    }
}