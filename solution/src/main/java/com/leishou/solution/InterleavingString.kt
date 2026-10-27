package com.leishou.solution

/*
    Given strings s1, s2, and s3, find whether s3 is formed by an interleaving of s1 and s2.
    An interleaving of two strings s and t is a configuration where s and t are divided into n and m
    substrings respectively, such that:

    s = s1 + s2 + ... + sn
    t = t1 + t2 + ... + tm
    |n - m| <= 1
    The interleaving is s1 + t1 + s2 + t2 + s3 + t3 + ... or t1 + s1 + t2 + s2 + t3 + s3 + ...
    Note: a + b is the concatenation of strings a and b.

    0 <= s1.length, s2.length <= 100
    0 <= s3.length <= 200
    s1, s2, and s3 consist of lowercase English letters.
*/
class InterleavingString {
    fun isInterleave(s1: String, s2: String, s3: String): Boolean {
        val n1 = s1.length
        val n2 = s2.length
        val n3 = s3.length
        if (n1 + n2 != n3)
            return false

        val memo = Array(n1 + 1) {
            IntArray(n2 + 1) { -1 }
        }

        fun dfs(index1: Int, index2: Int): Boolean {
            if (index1 == n1 && index2 == n2)
                return true

            if (memo[index1][index2] >= 0)
                return memo[index1][index2] > 0

            var ret = false
            val index3 = index1 + index2
            if (index1 < n1 && s1[index1] == s3[index3]) {
                ret = dfs(index1 + 1, index2)
            }

            if (!ret && index2 < n2 && s2[index2] == s3[index3]) {
                ret = dfs(index1, index2 + 1)
            }

            memo[index1][index2]= if (ret) 1 else 0
            return ret
        }

        val ret = dfs(0, 0)
        return ret
    }
}