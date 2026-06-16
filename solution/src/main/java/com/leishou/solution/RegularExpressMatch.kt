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
        val cache = hashMapOf<Pair<Int, Int>, Boolean>()
        fun dfs(sIndex: Int, pIndex: Int): Boolean {
            val pair = Pair(sIndex, pIndex)
            cache[pair]?.let {
                return it
            }

            if (pIndex == pLen) {
                val finished = sIndex == sLen
                cache[pair] = finished
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

            cache[pair] = ret
            return ret
        }

        return dfs(0, 0)
    }
}