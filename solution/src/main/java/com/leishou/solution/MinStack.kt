package com.leishou.solution

class MinStack {
    private val stack = ArrayDeque<Int>()
    private val minStack = ArrayDeque<IntArray>() // [value, count]
    fun push(`val`: Int) {
        val top = minStack.lastOrNull()
        if (top == null) {
            minStack.addLast(intArrayOf(`val`, 1))
        } else if (top[0] > `val`) {
            minStack.addLast(intArrayOf(`val`, 1))
        } else if (top[0] == `val`) {
            val ct = top[1]
            minStack.removeLast()
            minStack.addLast(intArrayOf(`val`, ct + 1))
        } else {
            // do nothing
        }
        stack.addLast(`val`)
    }

    fun pop() {
        val top = minStack.lastOrNull()
        if (top != null && top[0] == stack.last()) {
            when (val ct = top[1]) {
                0, 1 -> {
                    minStack.removeLast()
                }

                else -> {
                    minStack.removeLast()
                    minStack.addLast(intArrayOf(top[0], ct - 1))
                }
            }
        }
        stack.removeLast()
    }

    fun top(): Int {
        return stack.last()
    }

    fun getMin(): Int {
        return minStack.last()[0]
    }
}