package com.leishou.solution

import com.leishou.solution.utils.TreeNode

class RecoverBST {
    fun recoverTree(root: TreeNode?): Unit {
        var previus: TreeNode? = null
        var maxNode: TreeNode? = null
        var minNode: TreeNode? = null
        fun inorder(node: TreeNode?) {
            if (node == null) {
                return
            }

            inorder(node.left)
            previus?.let {
                if (it.`val` > node.`val`) {
                    if (maxNode == null || maxNode!!.`val` < it.`val`) {
                        maxNode = it
                    }

                    if (minNode == null || minNode!!.`val` > node.`val`) {
                        minNode = node
                    }
                }
            }

            previus = node
            inorder(node.right)
        }

        inorder(root)
        if (maxNode != null && minNode != null) {
            val temp = maxNode!!.`val`
            maxNode!!.`val` = minNode!!.`val`
            minNode!!.`val` = temp
        }
    }
}