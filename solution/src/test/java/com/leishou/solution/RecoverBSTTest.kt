package com.leishou.solution

import com.leishou.solution.utils.TreeNode
import org.junit.Test
import kotlin.test.assertContentEquals

class RecoverBSTTest {
    @Test
    fun testExample1() {
        val list = listOf(1, 3, null, null, 2)
        val tree = TreeNode.listToTreeNode(list)
        val sol = RecoverBST()
        sol.recoverTree(tree)
        assertContentEquals(listOf(3, 1, null, null, 2), TreeNode.treeNodeToList(tree))
    }

    @Test
    fun testExample2() {
        val list = listOf(3, 1, 4, null, null, 2)
        val tree = TreeNode.listToTreeNode(list)
        val sol = RecoverBST()
        sol.recoverTree(tree)
        assertContentEquals(listOf(2, 1, 4, null, null, 3), TreeNode.treeNodeToList(tree))
    }
}