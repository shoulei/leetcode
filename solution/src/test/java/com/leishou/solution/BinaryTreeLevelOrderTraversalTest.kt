package com.leishou.solution

import com.leishou.solution.utils.TreeNode
import org.junit.Test
import kotlin.test.assertEquals

class BinaryTreeLevelOrderTraversalTest {
    @Test
    fun testExample1() {
        val list = listOf(3, 9, 20, null, null, 15, 7)
        val tree = TreeNode.listToTreeNode(list)
        val sol = BinaryTreeLevelOrderTraversal()
        val actual = sol.levelOrder(tree)
        assertEquals(listOf(listOf(3), listOf(9, 20), listOf(15, 7)), actual)
    }

    @Test
    fun testExample2() {
        val list = listOf(1)
        val tree = TreeNode.listToTreeNode(list)
        val sol = BinaryTreeLevelOrderTraversal()
        val actual = sol.levelOrder(tree)
        assertEquals(listOf(listOf(1)), actual)
    }

    @Test
    fun testExample3() {
        val list = emptyList<Int?>()
        val tree = TreeNode.listToTreeNode(list)
        val sol = BinaryTreeLevelOrderTraversal()
        val actual = sol.levelOrder(tree)
        assertEquals(emptyList(), actual)
    }
}