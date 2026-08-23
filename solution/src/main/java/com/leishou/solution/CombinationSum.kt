package com.leishou.solution

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