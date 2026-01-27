package com.leishou.solution

import kotlin.math.min

class RegularExpressMatch {
    /*
        s contains only lowercase English letters.
        p contains only lowercase English letters, '.', and '*'.
     */
    fun isMatch(s: String, p: String): Boolean {
        val index = p.indexOf('*')
        if (index < 0) {
            return isEqualString(s, p)
        } else if (index == 0) {
            return isEqualString(s, p.substring(1))
        } else {
            val sub = p.substring(0, index - 1)
            val subLen = sub.length
            var sStr = s
            var pStr = p
            if (subLen > 0) {
                if (!isEqualString(s.substring(0, min(subLen, s.length)), sub)) {
                    return false
                }

                sStr = s.substring(subLen)
                pStr = p.substring(index - 1)
            }

            val c = pStr[0]
            if (pStr.length == 2) {
                for (i in sStr.indices) {
                    if (c != '.' && c != sStr[i]) {
                        return false
                    }
                }

                return true
            }

            if (isMatch(sStr, pStr.substring(2))) {
                return true
            }

            for (i in sStr.indices) {
                if (c == '.' || c == sStr[i]) {
                    if (isMatch(sStr.substring(i + 1), pStr.substring(2))) {
                        return true
                    }
                } else if (c != sStr[i]) {
                    return false
                }
            }

            return false
        }
    }

    private fun isEqualString(s: String, p: String): Boolean {
        val sLen = s.length
        val pLen = p.length

        if (sLen != pLen) return false
        for (i in 0 until sLen) {
            if (s[i] != p[i] && p[i] != '.' && s[i] != '.') return false
        }

        return true
    }
}