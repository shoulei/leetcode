package com.leishou.solution

/*
    Given a collection of candidate numbers (candidates) and a target number (target),
    find all unique combinations in candidates where the candidate numbers sum to target.

    Each number in candidates may only be used once in the combination.

    Note: The solution set must not contain duplicate combinations.

    1 <= candidates.length <= 100
    1 <= candidates[i] <= 50
    1 <= target <= 30
 */
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