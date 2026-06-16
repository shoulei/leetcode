package com.leishou.solution

class RegularExpressMatch {
    /*
        s contains only lowercase English letters.
        p contains only lowercase English letters, '.', and '*'.

        1, '.' Matches any single character.
        2, '*' Matches zero or more of the preceding element.
     */
    fun isMatch(s: String, p: String): Boolean {
        val sLen = s.length
        val pLen = p.length
        // 0: init, -1: false, 1: true
        val cache = Array(sLen + 1) {
            IntArray(pLen + 1) { 0 }
        }
        fun dfs(sIndex: Int, pIndex: Int): Boolean {
            val cc = cache[sIndex][pIndex]
            if (cc != 0) {
                return cc > 0
            }

            if (pIndex == pLen) {
                val finished = sIndex == sLen
                cache[sIndex][pIndex] = if (finished) 1 else -1
                return finished
            }

            val charMatched = pIndex < pLen && sIndex < sLen && (s[sIndex] == p[pIndex] || p[pIndex] == '.')
            val ret = if (pIndex < pLen - 1 && p[pIndex + 1] == '*') {
                // 0 consumed
                dfs(sIndex, pIndex + 2) ||
                // 1 consumed
                (charMatched && dfs(sIndex + 1, pIndex))
            } else {
                charMatched && dfs(sIndex + 1, pIndex + 1)
            }

            cache[sIndex][pIndex] =  if (ret) 1 else -1
            return ret
        }

        return dfs(0, 0)
    }
}