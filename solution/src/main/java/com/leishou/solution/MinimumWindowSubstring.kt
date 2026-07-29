package com.leishou.solution

class MinimumWindowSubstring {
    fun minWindow(s: String, t: String): String {
        val tMap = IntArray(58) { 0 }
        val sMap = IntArray(58) { 0 }
        val tLen = t.length
        for (i in t.indices) {
            val c = t[i] - 'A'
            tMap[c] = tMap[c] + 1
        }

        val sLen = s.length
        var left = 0
        var right = 0
        var matched = 0
        var targetleft = -1
        var targetRight = sLen
        var shortest = Int.MAX_VALUE
        while (right < sLen) {
            val c = s[right] - 'A'
            sMap[c] = sMap[c] + 1
            if (sMap[c] <= tMap[c]) {
                matched++
            }
            right++

            while (matched == tLen) {
                val l = right - left
                if (l < shortest) {
                    shortest = l
                    targetleft = left
                    targetRight = right
                }

                val leftC = s[left] - 'A'
                left++
                sMap[leftC] = sMap[leftC] - 1
                if (sMap[leftC] < tMap[leftC]) {
                    matched--
                }
            }
        }

        return if (targetleft >= 0) s.substring(targetleft, targetRight) else ""
    }
}