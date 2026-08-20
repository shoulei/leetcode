package com.leishou.solution

class RomanToInteger {
    fun romanToInt(s: String): Int {
        val length = s.length
        var i = 0
        var ret = 0
        while (i < length) {
            when (s[i]) {
                'M' -> {
                    ret += 1000
                    i++
                }

                'D' -> {
                    ret += 500
                    i++
                }

                'L' -> {
                    ret += 50
                    i++
                }


                'V' -> {
                    ret += 5
                    i++
                }

                'C' -> {
                    var handled = false
                    if (i < length - 1) {
                        if (s[i + 1] == 'M') {
                            ret += 900
                            i += 2
                            handled = true
                        } else if (s[i + 1] == 'D') {
                            ret += 400
                            i += 2
                            handled = true
                        }
                    }

                    if (!handled) {
                        ret += 100
                        i++
                    }
                }

                'X' -> {
                    var handled = false
                    if (i < length - 1) {
                        if (s[i + 1] == 'C') {
                            ret += 90
                            i += 2
                            handled = true
                        } else if (s[i + 1] == 'L') {
                            ret += 40
                            i += 2
                            handled = true
                        }
                    }

                    if (!handled) {
                        ret += 10
                        i++
                    }
                }

                'I' -> {
                    var handled = false
                    if (i < length - 1) {
                        if (s[i + 1] == 'X') {
                            ret += 9
                            i += 2
                            handled = true
                        } else if (s[i + 1] == 'V') {
                            ret += 4
                            i += 2
                            handled = true
                        }
                    }

                    if (!handled) {
                        ret += 1
                        i++
                    }
                }

                else -> {
                    // do nothing
                    i++
                }
            }
        }

        return ret
    }
}