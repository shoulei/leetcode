package com.leishou.solution

class SubstringOfAllWords {
    fun findSubstring(s: String, words: Array<String>): List<Int> {
        val len = s.length
        val wordLen = words[0].length
        val lastWordStart  = len - wordLen
        val need = words.groupingBy { it }.eachCount().toMutableMap()
        val window = HashMap<String, Int>()
        val result = mutableListOf<Int>()
        for (offset in 0 until wordLen) {
            var left = offset
            var right = offset
            var remainWords = words.size
            while (right <= lastWordStart) {
                val sub = s.substring(right, right + wordLen)
                right += wordLen
                if (need[sub] == null) {
                    window.clear()
                    left = right
                    remainWords = words.size
                    continue
                }

                window[sub] = (window[sub]?: 0) + 1
                val needCt = need[sub]!!
                remainWords--
                while (needCt < window[sub]!! && left < right) {
                    val leftSub = s.substring(left, left + wordLen)
                    window[leftSub] = window[leftSub]!! - 1
                    left += wordLen
                    remainWords++
                }

                if (remainWords == 0) {
                    result.add(left)
                }
            }

            window.clear()
        }

        return result
    }
}