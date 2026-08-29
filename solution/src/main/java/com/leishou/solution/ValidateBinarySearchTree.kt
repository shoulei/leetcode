package com.leishou.solution

import com.leishou.solution.utils.TreeNode

class ValidateBinarySearchTree {
    fun isValidBST(root: TreeNode?): Boolean {
        fun dfs(node: TreeNode?, min: Int?, max: Int?): Boolean {
            if (node == null)
                return true

            val nodeValue = node.`val`
            if ((min != null && nodeValue <= min) || (max != null && nodeValue >= max))
                return false

            if (node.left != null && node.left!!.`val` >= nodeValue)
                    return false

            if (node.right != null && node.right!!.`val` <= nodeValue)
                return false

            return dfs(node.left, min, nodeValue) && dfs(node.right, nodeValue, max)
        }

        return dfs(root, null, null)
    }
}