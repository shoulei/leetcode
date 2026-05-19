package com.leishou.solution

class LongestCommonPrefix {
    fun longestCommonPrefix(strs: Array<String>): String {
        var ret: String? = null
        for (str in strs) {
            if (ret == null) {
                ret = str
            } else if (ret.isEmpty()) {
                return ret
            } else {
                val prefix = StringBuilder()
                for (i in ret.indices) {
                    if (i >= str.length || ret[i] != str[i])
                        break

                    prefix.append(ret[i])
                }

                ret = prefix.toString()
            }
        }

        return ret?: ""
    }
}