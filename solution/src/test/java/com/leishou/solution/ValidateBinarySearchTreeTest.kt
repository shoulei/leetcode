package com.leishou.solution

import com.leishou.solution.utils.TreeNode
import org.junit.Test
import kotlin.test.assertEquals

class ValidateBinarySearchTreeTest {
    @Test
    fun testExample1() {
        val list = listOf(2, 1, 3)
        val tree = TreeNode.listToTreeNode(list)
        assertEquals(true, ValidateBinarySearchTree().isValidBST(tree))
    }

    @Test
    fun testExample2() {
        val list = listOf(5, 1, 4, null, null, 3, 6)
        val tree = TreeNode.listToTreeNode(list)
        assertEquals(false, ValidateBinarySearchTree().isValidBST(tree))
    }

    @Test
    fun testExample3() {
        val list = listOf(Int.MAX_VALUE)
        val tree = TreeNode.listToTreeNode(list)
        assertEquals(true, ValidateBinarySearchTree().isValidBST(tree))
    }
}