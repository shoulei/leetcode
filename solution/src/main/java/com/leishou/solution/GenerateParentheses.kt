package com.leishou.solution

class GenerateParentheses {
    fun generateParenthesis(n: Int): List<String> {
        val totalLen = n * 2
        var left = n
        var right = n
        val ret = mutableListOf<String>()
        val sb = StringBuilder(totalLen)
        var value = 0
        fun dfs(index: Int) {
            if (index == totalLen) {
                ret.add(sb.toString())
                return
            }

            if (left > 0) {
                sb.append('(')
                left--
                value++
                dfs(index + 1)
                value--
                left++
                sb.deleteCharAt(index)
            }

            if (right > 0) {
                sb.append(')')
                right--
                value--
                if (value < 0) {
                    value = 0
                    right++
                    sb.deleteCharAt(index)
                    return
                }

                dfs(index + 1)
                value++
                right++
                sb.deleteCharAt(index)
            }
        }

        dfs(0)
        return ret
    }
}