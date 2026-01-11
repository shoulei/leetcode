package com.leishou.solution

class ZigzagConversion {
    fun convert(s: String, numRows: Int): String {
        if (numRows == 1) return s
        val n = s.length
        var col = n / (numRows - 1) + 1
        val res = n % (2 * numRows - 2)
        if (res > numRows) col++
        val sb = StringBuilder()
        var index: Int
        for (i in 0 until numRows) {
            var j = 0
            val gap = 2 * (numRows - 1) - i * 2
            while (j < col) {
                if (i == 0 || i == numRows - 1) {
                    index = i + (numRows - 1) * j
                    if (index < n) sb.append(s[index])
                    j += 2
                } else {
                    val c = j / 2
                    if (j % 2 == 0) {
                        index = i + (numRows - 1) * c * 2
                        if (index < n) sb.append(s[index])
                    } else {
                        index = i + (numRows - 1)  * c * 2 + gap
                        if (index < n) sb.append(s[index])
                    }
                    j++
                }
            }
        }

        return sb.toString()
    }
}