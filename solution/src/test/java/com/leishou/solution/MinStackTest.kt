package com.leishou.solution

import org.junit.Test
import kotlin.test.assertEquals

class MinStackTest {
    @Test
    fun testExample1() {
        val minStack = MinStack()
        minStack.push(-2)
        minStack.push(0)
        minStack.push(-3)
        assertEquals(minStack.getMin(), -3)
        minStack.pop()
        assertEquals(minStack.top(), 0)
        assertEquals(minStack.getMin(), -2)
    }
}