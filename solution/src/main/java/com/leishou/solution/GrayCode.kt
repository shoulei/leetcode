package com.leishou.solution

class GrayCode {
    fun grayCode(n: Int): List<Int> {
        val ret = ArrayList<Int>(1 shl n)
        fun build(num: Int) {
            if (num == 1) {
                ret.add(0)
                ret.add(1)
                return
            }

            build(num - 1)
            val size = ret.size
            val highestBit = 1 shl (num - 1)
            for (i in size - 1 downTo 0) {
                ret.add(highestBit or ret[i])
            }
        }

        build(n)
        return ret
    }
}