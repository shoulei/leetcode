package com.leishou.solution

class WildcardMatching {
    /*
       '?' Matches any single character.
       '*' Matches any sequence of characters (including the empty sequence).
     */
    fun isMatch(s: String, p: String): Boolean {
        // shrink p string
        val sb = buildString {
            var prevStar = false
            for (c in p) {
                if (c == '*') {
                    if (!prevStar) append(c)
                    prevStar = true
                } else {
                    append(c)
                    prevStar = false
                }
            }
        }

        val sLen = s.length
        val pLen = sb.length
        val array = Array(sLen + 1) {
            IntArray(pLen + 1) { -1 } // -1: uninitialized. 0: unmatched, 1: matched
        }

        fun dfs(sIndex: Int, pIndex: Int): Boolean {
            if (pIndex == pLen) {
                val ret = sIndex == sLen
                array[sIndex][pIndex] = if (ret) 1 else 0
                return ret
            }

            val cached = array[sIndex][pIndex]
            if (cached != -1) {
                return cached == 1
            }

            val ret = when (sb[pIndex]) {
                '?' -> {
                    sIndex < sLen && dfs(sIndex + 1, pIndex + 1)
                }

                '*' -> {
                    dfs(sIndex, pIndex + 1) || (sIndex < sLen && dfs(sIndex + 1, pIndex))
                }

                else -> {
                    sIndex < sLen && s[sIndex] == sb[pIndex] && dfs(sIndex + 1, pIndex + 1)
                }
            }

            array[sIndex][pIndex] = if (ret) 1 else 0
            return ret
        }

        return dfs(0, 0)
    }
}