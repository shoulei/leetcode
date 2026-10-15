package com.leishou.solution

/*
    Given two strings word1 and word2, return the minimum number of operations required to convert
    word1 to word2. You have the following three operations permitted on a word:
    1, Insert a character
    2, Delete a character
    3, Replace a character

    0 <= word1.length, word2.length <= 500
    word1 and word2 consist of lowercase English letters.
 */
class EditDistance {
    fun minDistance(word1: String, word2: String): Int {
        val len1 = word1.length
        val len2 = word2.length
        val memo = Array(len1 + 1) {
            IntArray(len2 + 1) { -1 }
        }

        fun dfs(idx1: Int, idx2: Int): Int {
            // word reaches end, we can make it equal by adding Diff letters in tail
            if (idx2 >= len2)
                return len1 - idx1

            if (idx1 >= len1)
                return len2 - idx2

            if (memo[idx1][idx2] != -1)
                return memo[idx1][idx2]

            val result = when {
                word1[idx1] == word2[idx2] -> {
                    // do not need to cal minOf(1 + dfs(idx1, idx2 + 1), 1 + dfs(idx1 + 1, idx2))
                    // because obviously dfs(idx1 + 1, idx2 + 1) will not bigger than those
                    dfs(idx1 + 1, idx2 + 1) // consume
                }

                else -> {
                    val r0 = 1 + dfs(idx1 + 1, idx2 + 1) // replace a letter
                    val r1 = 1 + dfs(idx1, idx2 + 1) // insert a letter in word1 before idx1
                    val r2 = 1 + dfs(idx1 + 1, idx2) // insert a letter in word2 before idx2
                    minOf(r0, r1, r2)
                }
            }

            memo[idx1][idx2] = result
            return result
        }

        return dfs(0, 0)
    }
}