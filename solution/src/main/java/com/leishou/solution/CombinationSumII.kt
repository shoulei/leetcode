package com.leishou.solution

class CombinationSumII {
    fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {
        candidates.sort()
        val ret = ArrayList<ArrayList<Int>>()
        val size = candidates.size
        val path = ArrayList<Int>()
        fun dfs(remain: Int, startIndex: Int) {
            if (remain == 0) {
                ret.add(ArrayList(path))
                return
            }

            for (i in startIndex until size) {
                val num = candidates[i]
                if (num > remain)
                    return

                if (i != startIndex && i > 0 && candidates[i - 1] == num) {
                    continue
                }

                path.add(num)
                dfs(remain - num, i + 1)
                path.removeLast()
            }
        }

        dfs(target, 0)
        return ret
    }
}