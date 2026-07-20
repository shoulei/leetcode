package com.leishou.solution

class LongestValidParentheses {
    fun longestValidParentheses(s: String): Int {
        val stack = IntArray(s.length + 1)
        var longest = 0
        var top = 0
        stack[top] = -1
        for (i in s.indices) {
            if (s[i] == '(') {
                stack[++top] = i
            } else {
                top--
                if (top < 0) {
                    stack[0] = i
                    top = 0
                } else {
                    longest = maxOf(longest, i - stack[top])
                }
            }
        }

        return longest
    }
}