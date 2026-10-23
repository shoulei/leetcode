package com.leishou.solution

/*
    Given two non-negative integers num1 and num2 represented as strings, return the product of num1
    and num2, also represented as a string.

    Note: You must not use any built-in BigInteger library or convert the inputs to integer directly.

    1 <= num1.length, num2.length <= 200
    num1 and num2 consist of digits only.
    Both num1 and num2 do not contain any leading zero, except the number 0 itself.
 */
class MultiplyStrings {
    fun multiply(num1: String, num2: String): String {
        if (num1 == "0" || num2 == "0")
            return "0"

        val size1 = num1.length
        val size2 = num2.length
        val result = IntArray(size1 + size2) { 0 }

        for (i in 0 until size1) {
            val n1 = num1[size1 - 1 - i] - '0'
            for (j in 0 until size2) {
                val n2 = num2[size2 - 1 - j] - '0'
                val low = i + j
                val high = i + j + 1
                val product = n1 * n2 + result[low]
                result[low] = product % 10
                result[high] += product / 10
            }
        }

        val sb = StringBuilder()
        var numStart = false
        for (i in size1 + size2 - 1 downTo 0) {
            if (!numStart && result[i] != 0) {
                numStart = true
            }

            if (numStart) {
                sb.append(result[i])
            }
        }

        return sb.toString()
    }
}