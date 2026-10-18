package com.leishou.solution

import com.leishou.solution.utils.TreeNode

/*
    Given the root of a binary tree, return the level order traversal of its nodes' values.
    (i.e., from left to right, level by level).

    The number of nodes in the tree is in the range [0, 2000].
    -1000 <= Node.val <= 1000
 */
class BinaryTreeLevelOrderTraversal {
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        if (root == null)
            return  emptyList()

        val queue = ArrayDeque<TreeNode>()
        queue.addLast(root)
        val result = mutableListOf<List<Int>>()
        while (queue.isNotEmpty()) {
            val layCt = queue.size
            val layerList = ArrayList<Int>(layCt)
            repeat (layCt) {
                val node = queue.removeFirst()
                layerList.add(node.`val`)
                node.left?.let { queue.addLast(it) }
                node.right?.let { queue.addLast(it) }
            }

            result.add(layerList)
        }

        return result
    }
}