package com.leishou.solution

/*
    Given an array of distinct integers candidates and a target integer target, return a list of
    all unique combinations of candidates where the chosen numbers sum to target. You may return the
    combinations in any order.

    The same number may be chosen from candidates an unlimited number of times. Two combinations are
    unique if the frequency of at least one of the chosen numbers is different.

    The test cases are generated such that the number of unique combinations that sum up to target
    is less than 150 combinations for the given input.

    1 <= candidates.length <= 30
    2 <= candidates[i] <= 40
    All elements of candidates are distinct.
    1 <= target <= 40
 */
class CombinationSum {
    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        val ret = ArrayList<ArrayList<Int>>()
        val path = ArrayList<Int>()
        val size = candidates.size
        fun dfs(rest: Int, startIndex: Int) {
            when {
                rest == 0 -> {
                    ret.add(ArrayList(path))
                }

                rest < 0 || startIndex >= size -> {
                    // do nothing
                }

                else -> {
                    val num = candidates[startIndex]
                    val maxCt = 1 + rest / num
                    for (i in 0 until maxCt) {
                        val remain = rest - i * num
                        repeat(i) {
                            path.add(num)
                        }
                        dfs(remain, startIndex + 1)
                        repeat(i) {
                            path.removeLast()
                        }
                    }
                }
            }
        }

        dfs(target, 0)
        return ret
    }
}