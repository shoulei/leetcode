package com.leishou.solution

import com.leishou.solution.utils.TreeNode

/*
    Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

    According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between
    two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow
    a node to be a descendant of itself).”

    The number of nodes in the tree is in the range [2, 105].
    -10^9 <= Node.val <= 10^9
    All Node.val are unique.
    p != q
    p and q will exist in the tree
 */
class LCAOfABinaryTree {
    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        if (root == null || p == null || q == null)
            return null

        // return (node, isLCA)
        fun findTargetOrLCA(node: TreeNode?): Pair<TreeNode?, Boolean> {
            if (node == null)
                return Pair(null, false)

            var isTarget = false
            if (node === p || node === q) {
                isTarget = true
            }

            val left = findTargetOrLCA(node.left)
            if (left.second)
                return left

            val right = findTargetOrLCA(node.right)
            if (right.second)
                return right

            if (left.first != null && right.first != null)
                return Pair(node, true)

            return if (isTarget) {
                Pair(node, left.first != null || right.first != null)
            } else {
                if (left.first != null) left else right
            }
        }

        val ret = findTargetOrLCA(root)
        return if (ret.second) ret.first else null
    }
}