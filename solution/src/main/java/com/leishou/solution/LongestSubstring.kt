package com.leishou.solution

import kotlin.math.max

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