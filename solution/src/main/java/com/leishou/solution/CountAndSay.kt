package com.leishou.solution

import java.util.Arrays

class CountAndSay {
    fun countAndSay(n: Int): String {
        fun dfs(k: Int): String {
            if (k == 1)
                return "1"

            val str = dfs(k - 1)
            var pre = str[0]
            var ct = 0
            val sb = StringBuilder()
            for (c in str) {
                if (c != pre) {
                    sb.append(ct).append(pre)
                    pre = c
                    ct = 1
                } else {
                    ct++
                }
            }

            sb.append(ct).append(pre)
            return sb.toString()
        }

        return dfs(n)
    }
}