package com.leishou.solution

class PalindromeNumber {
    fun isPalindrome(x: Int): Boolean {
        if (x < 0) return false

        var value = x
        var reversed = 0
        while (value > 0) {
            val v = value % 10
            reversed = reversed * 10 + v
            value /= 10
        }

        return x == reversed
    }
}