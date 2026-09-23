package com.leishou.solution

/*
    Given a string s, return whether s is a valid number.
    For example, all the following are valid numbers: "2", "0089", "-0.1", "+3.14", "4.", "-.9",
    "2e10", "-90E3", "3e+7", "+6e-1", "53.5e93", "-123.456e789", while the following are not valid
    numbers: "abc", "1a", "1e", "e3", "99e2.5", "--6", "-+3", "95a54e53".

    Formally, a valid number is defined using one of the following definitions:
    1, An integer number followed by an optional exponent.
    2, A decimal number followed by an optional exponent.
    3, An integer number is defined with an optional sign '-' or '+' followed by digits.

    A decimal number is defined with an optional sign '-' or '+' followed by one of the following definitions:
    1, Digits followed by a dot '.'.
    2, Digits followed by a dot '.' followed by digits.
    3, A dot '.' followed by digits.

    An exponent is defined with an exponent notation 'e' or 'E' followed by an integer number.
    The digits are defined as one or more digits.
 */
class ValidNumber {
    fun isNumber(s: String): Boolean {
        /*
            digit:  hasDigit = true
            e/E:    digit is seen, it appears only once, not last one
            +/-:    only in beginning, or follows e, not last one
            .:      Only appears before e, and only once
         */
        val n = s.length
        var hasDigit = false
        var hasExponent = false // if e exists
        var hasDot = false // if . exists
        var exponentGood = true // if part after e is illegal
        for (i in s.indices) {
            when (s[i]) {
                in '0'..'9' -> {
                    hasDigit = true
                    if (hasExponent)
                        exponentGood = true
                }

                'e', 'E' -> {
                    if (!hasDigit || hasExponent) // digit is seen, it appears only once
                        return false

                    exponentGood = false // e last one check by this
                    hasExponent = true
                }

                '+', '-' -> {
                    if (i > 0 && !hasExponent) // only in beginning
                        return false

                    if (i == n - 1) // not last one
                        return false

                    if (i > 0 && s[i - 1] != 'e' && s[i - 1] != 'E') { //  or follows e
                        return false
                    }
                }

                '.' -> {
                    if (hasExponent || hasDot) // Only appears before e, and only once
                        return false

                    hasDot = true
                }

                else -> {
                    return false
                }
            }
        }

        return hasDigit && exponentGood
    }
}