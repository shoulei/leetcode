package com.leishou.solution

import kotlin.math.abs

class DivideTwoIntegers {
    fun divide(dividend: Int, divisor: Int): Int {
        if (dividend == Int.MIN_VALUE && divisor == -1) return Int.MAX_VALUE
        if (divisor == 1) return dividend
        if (divisor == -1) return -dividend
        val positive = (dividend >= 0 && divisor > 0) || (dividend < 0 && divisor < 0)
        val absDividend = abs(dividend.toLong())
        val absDivisor = abs(divisor.toLong())
        val keys = LongArray(32)
        val values = LongArray(32)
        var ret = 1L
        var acc = absDivisor
        var index = 0
        while (acc <= absDividend) {
            keys[index] = acc
            values[index] = ret
            acc = acc shl 1
            ret = ret shl 1
            index++
        }

        ret = 0
        var remain = absDividend
        for (i in index - 1 downTo 0) {
            if (remain >= keys[i]) {
                remain -= keys[i]
                ret += values[i]
            }
        }

        return if (positive) ret.toInt() else -ret.toInt()
    }
}