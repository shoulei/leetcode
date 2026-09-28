package com.leishou.solution

class CourseSchedule {
    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        val neighbor = Array(numCourses) { mutableListOf<Int>() }
        for (edge in prerequisites) {
            neighbor[edge[1]].add(edge[0])
        }

        // 0: unvisited, 1: visiting, 2: visited
        val state = IntArray(numCourses) { 0 }
        // check if any cycle
        fun dfs(node: Int): Boolean {
            if (state[node] == 1)
                return true

            if (state[node] == 0) {
                state[node] = 1
                for (i in neighbor[node]) {
                    if (state[i] == 1)
                        return true
                    if (dfs(i))
                        return true
                }
                state[node] = 2
            }

            return false
        }

        for (i in neighbor.indices) {
            if (neighbor[i].isNotEmpty() && state[i] == 0) {
                if (dfs(i)) {
                    return false
                }
            }
        }

        return true
    }
}