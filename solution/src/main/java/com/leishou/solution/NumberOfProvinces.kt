package com.leishou.solution

class NumberOfProvinces {
    fun findCircleNum(isConnected: Array<IntArray>): Int {
        val cities = isConnected.size
        val visitArray = BooleanArray(cities) { false }
        var circles = 0
        fun visit(index: Int) {
            for (i in 0 until cities) {
                if (i == index) continue
                if (visitArray[i]) continue
                if (isConnected[i][index] == 1) {
                    visitArray[i] = true
                    visit(i)
                }
            }
        }

        for (i in 0 until cities) {
            if (visitArray[i]) continue
            visitArray[i] = true
            circles++
            visit(i)
        }

        return circles
    }
}