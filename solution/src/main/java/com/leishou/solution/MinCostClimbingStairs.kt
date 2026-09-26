package com.leishou.solution

/*
    You are given an integer array cost where cost[i] is the cost of ith step on a staircase.
    Once you pay the cost, you can either climb one or two steps.
    You can either start from the step with index 0, or the step with index 1.
    Return the minimum cost to reach the top of the staircase, which is the position just past the
    last step (index cost.length).
 */
class MinCostClimbingStairs {
    fun minCostClimbingStairs(cost: IntArray): Int {
        var dp2 = 0
        var dp1 = 0
        for (i in 2..cost.size) {
            val current = minOf(dp2 + cost[i - 2], dp1 + cost[i - 1])
            dp2 = dp1
            dp1 = current
        }

        return dp1
    }
}