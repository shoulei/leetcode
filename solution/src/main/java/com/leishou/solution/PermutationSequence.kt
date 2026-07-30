package com.leishou.solution

class PermutationSequence {
    fun getPermutation(n: Int, k: Int): String {
        val numsList = (1..n).toMutableList()
        val factArray = IntArray(n) { 1 }
        for (i in 1 until n) {
            factArray[i] = factArray[i - 1] * i
        }

        var index = k - 1
        val sb = StringBuilder()
        var size = n - 1
        while (numsList.isNotEmpty()) {
            val order = index / factArray[size]
            sb.append(numsList[order])
            numsList.removeAt(order)
            index %= factArray[size]
            size--
        }
        return sb.toString()
    }
}