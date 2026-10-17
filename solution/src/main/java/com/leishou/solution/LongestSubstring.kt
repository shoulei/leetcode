package com.leishou.solution

import kotlin.math.max

/*
    Given a string s, find the length of the longest substring without duplicate characters.

    0 <= s.length <= 105
    s consists of English letters, digits, symbols and spaces.
 */
class LongestSubstring {
    fun lengthOfLongestSubstring(s: String): Int {
        val map = HashMap<Char, Int>()
        var longest = 0
        var left = -1
        for (i in s.indices) {
            val temp = map[s[i]]
            if (temp != null && temp > left) {
                left = temp
            }
            val length = i - left
            longest = max(longest, length)
            map[s[i]] = i
        }

        return longest
    }
}