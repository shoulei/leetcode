package com.leishou.solution

import com.leishou.solution.utils.TreeNode
import org.junit.Test
import kotlin.test.assertEquals

class LCAOfABinaryTreeTest {
    @Test
    fun testExample1() {
        val list = listOf(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4)
        val tree = TreeNode.listToTreeNode(list)
        val p = TreeNode.findNode(tree, 5)
        val q = TreeNode.findNode(tree, 1)
        val expect = TreeNode.findNode(tree, 3)
        assertEquals(expect, LCAOfABinaryTree().lowestCommonAncestor(tree, p, q))
    }

    @Test
    fun testExample2() {
        val list = listOf(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4)
        val tree = TreeNode.listToTreeNode(list)
        val p = TreeNode.findNode(tree, 5)
        val q = TreeNode.findNode(tree, 4)
        val expect = TreeNode.findNode(tree, 5)
        assertEquals(expect, LCAOfABinaryTree().lowestCommonAncestor(tree, p, q))
    }

    @Test
    fun testExample3() {
        val list = listOf(1, 2)
        val tree = TreeNode.listToTreeNode(list)
        val p = TreeNode.findNode(tree, 1)
        val q = TreeNode.findNode(tree, 2)
        val expect = TreeNode.findNode(tree, 1)
        assertEquals(expect, LCAOfABinaryTree().lowestCommonAncestor(tree, p, q))
    }

    @Test
    fun testExample4() {
        val list = listOf(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4)
        val tree = TreeNode.listToTreeNode(list)
        val p = TreeNode.findNode(tree, 0)
        val q = TreeNode.findNode(tree, 8)
        val expect = TreeNode.findNode(tree, 1)
        assertEquals(expect, LCAOfABinaryTree().lowestCommonAncestor(tree, p, q))
    }
}