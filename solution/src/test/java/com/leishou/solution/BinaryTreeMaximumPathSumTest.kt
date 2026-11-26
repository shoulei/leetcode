package com.leishou.solution

import com.leishou.solution.utils.TreeNode
import org.junit.Test
import kotlin.test.assertEquals

class BinaryTreeMaximumPathSumTest {
    @Test
    fun testExample1() {
        val list = listOf(1, 2, 3)
        val tree = TreeNode.listToTreeNode(list)
        val sol = BinaryTreeMaximumPathSum()
        assertEquals(6, sol.maxPathSum(tree))
    }

    @Test
    fun testExample2() {
        val list = listOf(-10, 9, 20, null, null, 15, 7)
        val tree = TreeNode.listToTreeNode(list)
        val sol = BinaryTreeMaximumPathSum()
        assertEquals(42, sol.maxPathSum(tree))
    }

    @Test
    fun testExample3() {
        val list = listOf(-2, -1)
        val tree = TreeNode.listToTreeNode(list)
        val sol = BinaryTreeMaximumPathSum()
        assertEquals(-1, sol.maxPathSum(tree))
    }
}