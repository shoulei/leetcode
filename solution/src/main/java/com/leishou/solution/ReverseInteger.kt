package com.leishou.solution

import kotlin.math.abs
import kotlin.math.pow

class ReverseInteger {
    fun reverse(x: Int): Int {
        val negative = x < 0
        var abs = abs(x)
        val map = mutableMapOf<Int, Int>()
        var max = -1
        for (i in 9 downTo 0) {
            val base = 10.0.pow(i).toInt()
            val n = abs / base
            if (n > 0) {
                if (max < 0) {
                    max = i
                }
                map[max - i] = n
                abs -= n * base
            }
        }

        var ret = 0.0
        map.forEach {
            ret += it.value * 10.0.pow(it.key)
            if (ret > Int.MAX_VALUE) {
                ret = 0.0
                return@forEach
            }
        }

        return ret.toInt() * if (negative) -1 else 1
    }
}