package com.leishou.solution

/*
    Given a string s, partition s such that every substring of the partition is a palindrome.
    Return all possible palindrome partitioning of s.

    1 <= s.length <= 16
    s contains only lowercase English letters.
 */
class PalindromePartitioning {
    fun partition(s: String): List<List<String>> {
        val sLen = s.length
        val partitionList = mutableListOf<Int>()
        val ret = mutableListOf<List<String>>()
        val palindromeArray = Array(sLen + 1) {
            IntArray(sLen + 1) { -1 } // -1 means not initialized, 0: false, 1: true
        }

        // start: inclusive; end: exclusive
        fun isPalindrome(start: Int, end: Int): Boolean {
            val last = end - 1
            if (start >= last) {
                palindromeArray[start][end] = 1
                return true
            }

            if (palindromeArray[start][end] != -1)
                return palindromeArray[start][end] == 1

            palindromeArray[start][end] = if (s[start] == s[last] && isPalindrome(start + 1, end - 1)) 1 else 0
            return palindromeArray[start][end] == 1
        }

        fun dfs(start: Int) {
            if (start == s.length) {
                ret.add(getPartitionList(s, partitionList))
                return
            }

            for (i in start + 1 until s.length + 1) {
                if (isPalindrome(start, i)) {
                    partitionList.add(i)
                    dfs(i)
                    partitionList.remove(i)
                }
            }
        }

        dfs(0)
        return ret
    }

    private fun getPartitionList(s: String, array: List<Int>): List<String> {
        return mutableListOf<String>().apply {
            var start = 0
            for (i in array) {
                add(s.substring(start, i))
                start = i
            }
        }
    }
}