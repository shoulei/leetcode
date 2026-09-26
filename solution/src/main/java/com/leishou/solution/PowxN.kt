package com.leishou.solution

import kotlin.math.abs

class PowxN {
    fun myPow(x: Double, n: Int): Double {
        if (x == 1.0)
            return 1.0
        else if (x == -1.0)
            return if (n % 2 == 0) 1.0 else -1.0

        var ret = 1.0
        val negative = n < 0
        var base = if (negative) 1 / x else x
        var exponent = if (negative) -(n.toLong()) else n.toLong()
        while (exponent > 0) {
            if (exponent and 1L != 0L) {
                ret *= base
            }
            base *= base
            exponent = exponent shr 1
        }


        return ret
    }
}