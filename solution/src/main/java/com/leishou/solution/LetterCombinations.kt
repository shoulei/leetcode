package com.leishou.solution

class LetterCombinations {
    fun letterCombinations(digits: String): List<String> {
        return dfs(digits)
    }

    private fun dfs(digits: String): List<String> {
        val map = arrayOf("", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz")
        val ret: MutableList<String> = mutableListOf()
        val sb = StringBuilder()
        val digitsLen = digits.length
        fun dfsInternal(index: Int) {
            if (index == digitsLen) {
                ret.add(sb.toString())
            } else {
                val chars = map[digits[index] - '0']
                for (c in chars) {
                    sb.append(c)
                    dfsInternal(index + 1)
                    sb.deleteCharAt(index)
                }
            }
        }

        dfsInternal(0)
        return ret
    }

    private fun bfs(digits: String): List<String> {
        val map = arrayOf("", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz")
        var ret: List<String> = emptyList()
        for (d in digits) {
            ret = combine(ret, map[d - '0'])
        }

        return ret
    }

    private fun combine(strList: List<String>, chars: String?): List<String> {
        return mutableListOf<String>().apply {
            if (chars.isNullOrEmpty()) {
                addAll(strList)
            } else {
                if (strList.isEmpty()) {
                    for (c in chars) {
                        add(c.toString())
                    }
                } else {
                    for (str in strList) {
                        for (c in chars) {
                            add(str.plus(c))
                        }
                    }
                }
            }
        }
    }
}