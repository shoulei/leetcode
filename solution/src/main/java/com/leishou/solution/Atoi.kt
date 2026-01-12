package com.leishou.solution

class Atoi {
    fun myAtoi(s: String): Int {
        var start = false
        var sign = 1
        var res = 0.0
        for (c in s) {
            when (c) {
                in '0'..'9' -> {
                    start = true
                    res = res * 10 + (c - '0')
                }

                '+' -> {
                    if (start) {
                        break
                    } else {
                        start = true
                    }
                }

                '-' -> {
                    if (start) {
                        break
                    } else {
                        sign = -1
                        start = true
                    }
                }

                ' ' -> {
                    if (start) {
                        break
                    }
                }

                else -> {
                    break
                }
            }
        }

        return (res * sign).toInt()
    }
}