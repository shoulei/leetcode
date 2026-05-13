package com.leishou.solution

import kotlin.math.pow

class IntegerToRoman {
    fun intToRoman(num: Int): String {
        require(num in 1..3999)

        val ret = StringBuilder()
        var restNum = num
        for (i in 3 downTo 0) {
            val base = 10.0.pow(i).toInt()
            if (restNum >= base) {
                val n = restNum / base
                ret.append(digitsToRoman(n, i))
                restNum -= n * base
            }
        }

        return ret.toString()
    }

    private fun digitsToRoman(num: Int, digit: Int): String {
        return when (digit) {
            0 -> onesDigitsToRoman(num)
            1 -> tensDigitsToRoman(num)
            2 -> hundredsDigitsToRoman(num)
            else -> thousandsDigitsToRoman(num)
        }
    }

    private fun onesDigitsToRoman(num: Int): String {
        val modFive = num % 5
        val divFive = num / 5
        return if (divFive == 0) {
            if (modFive != 4) {
                "I".repeat(modFive)
            } else {
                "IV"
            }
        } else {
            if (modFive != 4) {
                "V" + "I".repeat(modFive)
            } else {
                "IX"
            }
        }
    }

    private fun tensDigitsToRoman(num: Int): String {
        val modFive = num % 5
        val divFive = num / 5
        return if (divFive == 0) {
            if (modFive != 4) {
                "X".repeat(modFive)
            } else {
                "XL"
            }
        } else {
            if (modFive != 4) {
                "L" + "X".repeat(modFive)
            } else {
                "XC"
            }
        }
    }

    private fun hundredsDigitsToRoman(num: Int): String {
        val modFive = num % 5
        val divFive = num / 5
        return if (divFive == 0) {
            if (modFive != 4) {
                "C".repeat(modFive)
            } else {
                "CD"
            }
        } else {
            if (modFive != 4) {
                "D" + "C".repeat(modFive)
            } else {
                "CM"
            }
        }
    }

    private fun thousandsDigitsToRoman(num: Int): String {
        return "M".repeat(num)
    }
}