package com.leishou.solution

import com.leishou.solution.utils.Node
import org.junit.Test
import kotlin.test.assertEquals

class CloneGraphTest {
    @Test
    fun testExample1() {
        val list = listOf(listOf(2, 4), listOf(1, 3), listOf(2, 4), listOf(1, 3))
        val graph = Node.listToNode(list)
        val sol = CloneGraph()
        assertEquals(list, Node.nodeToList(sol.cloneGraph(graph)))
    }

    @Test
    fun testExample2() {
        val list = listOf(emptyList<Int>())
        val graph = Node.listToNode(list)
        val sol = CloneGraph()
        assertEquals(list, Node.nodeToList(sol.cloneGraph(graph)))
    }
}