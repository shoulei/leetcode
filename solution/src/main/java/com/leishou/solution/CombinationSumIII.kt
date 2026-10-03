package com.leishou.solution

/*
    Find all valid combinations of k numbers that sum up to n such that the following conditions are
    true:
    1, Only numbers 1 through 9 are used.
    2, Each number is used at most once.

    Return a list of all possible valid combinations. The list must not contain the same combination
    twice, and the combinations may be returned in any order.

    2 <= k <= 9
    1 <= n <= 60
 */
class CombinationSumIII {
    fun combinationSum3(k: Int, n: Int): List<List<Int>> {
        if (k > n)
            return emptyList()
        val ret = mutableListOf<List<Int>>()
        // Exhaustive list all possibility
        for (bitMask in 1 until (1 shl 9)) {
            if (bitMask.countOneBits() != k)
                continue

            val path = mutableListOf<Int>()
            var sum = 0
            for (i in 1..9) {
                if (bitMask and (1 shl (i - 1)) != 0) {
                    sum += i
                    path.add(i)
                }
            }

            if (sum == n) {
                ret.add(path)
            }
        }

        return ret
    }
}