package com.leishou.solution

/*
    Given a string s, partition s such that every substring of the partition is a palindrome.
    Return the minimum cuts needed for a palindrome partitioning of s.

    1 <= s.length <= 2000
    s consists of lowercase English letters only.
 */
class PalindromePartitioningII {
    fun minCut(s: String): Int {
        val length = s.length
        // Array[start][end] to mark if it is palindrome, start is inclusive and end is exclusive
        val palindromeMark = Array(length + 1) {
            IntArray(length + 1) { -1 } // 0: false, 1: true, -1, uninitialized
        }

        // start: inclusive, end: exclusive
        fun isPalindrome(start: Int, end: Int): Boolean {
            if (palindromeMark[start][end] >= 0) {
                return palindromeMark[start][end] > 0
            }

            if (end <= start + 1) {
                palindromeMark[start][end] = 1
                return true
            }

            val ret = s[start] == s[end - 1] && isPalindrome(start + 1, end - 1)
            val value = if (ret) 1 else 0
            palindromeMark[start][end] = value
            return ret
        }

        var cut = 0
        val leftList = hashSetOf(0)
        val rightList = hashSetOf(length)
        var expandList: HashSet<Int>
        var targetList: HashSet<Int>
        val leftVisited = BooleanArray(length + 1) { false }
        val rightVisited = BooleanArray(length + 1) { false }
        out@ while (leftList.isNotEmpty() && rightList.isNotEmpty()) {
            var isLeftExpand = true
            if (leftList.size <= rightList.size) {
                expandList = leftList
                targetList = rightList
            } else {
                expandList = rightList
                targetList = leftList
                isLeftExpand = false
            }

            val tempList = mutableListOf<Int>()
            if (isLeftExpand) {
                for (index in expandList) {
                    for (end in index + 1..length) {
                        if (!leftVisited[end] && isPalindrome(index, end)) {
                            if (targetList.contains(end)) {
                                break@out
                            }
                            tempList.add(end)
                            leftVisited[end] = true
                        }
                    }
                }
            } else {
                for (index in expandList) {
                    for (start in index - 1 downTo 0) {
                        if (!rightVisited[start] && isPalindrome(start, index)) {
                            if (targetList.contains(start)) {
                                break@out
                            }
                            tempList.add(start)
                            rightVisited[start] = true
                        }
                    }
                }
            }

            cut++
            if (isLeftExpand) {
                leftList.clear()
                leftList.addAll(tempList)
            } else {
                rightList.clear()
                rightList.addAll(tempList)
            }
        }

        return cut
    }
}