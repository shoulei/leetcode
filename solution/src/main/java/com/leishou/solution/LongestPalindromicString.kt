package com.leishou.solution

class LongestPalindromicString {
    fun longestPalindrome(s: String): String {
        val len = s.length
        if (len < 2) return s
        var maxLeft = 0
        var maxRight = 1
        var left: Int
        var right: Int
        var index = 0
        while (index < len) {
            val mid = s[index]
            left = index - 1
            right = index + 1
            while (right < len && s[right] == mid) {
                right++
                index++
            }

            while (left >= 0 && right < len) {
                if (s[left] == s[right]) {
                    left--
                    right++
                } else {
                    break
                }
            }

            if (maxRight - maxLeft < right - left) {
                maxRight = right
                maxLeft = left
            }

            index++
        }

        return s.substring(maxLeft + 1, maxRight)
    }
}