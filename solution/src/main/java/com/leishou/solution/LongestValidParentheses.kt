package com.leishou.solution

class LongestValidParentheses {
    fun longestValidParentheses(s: String): Int {
        val stack = ArrayDeque<Int>()
        var longest = 0
        stack.addLast(-1)
        for (i in s.indices) {
            if (s[i] == '(') {
                stack.addLast(i)
            } else {
                stack.removeLast()
                if (stack.isEmpty()) {
                    stack.addLast(i)
                } else {
                    longest = maxOf(longest, i - stack.last())
                }
            }
        }

        return longest
    }
}