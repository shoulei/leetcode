package com.leishou.solution

import com.leishou.solution.utils.TreeNode
import kotlin.time.Duration.Companion.seconds

/*
    A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence
    has an edge connecting them. A node can only appear in the sequence at most once. Note that the
    path does not need to pass through the root.

    The path sum of a path is the sum of the node's values in the path.

    Given the root of a binary tree, return the maximum path sum of any non-empty path.

    The number of nodes in the tree is in the range [1, 3 * 10^4].
    -1000 <= Node.val <= 1000
 */
class BinaryTreeMaximumPathSum {
    fun maxPathSum(root: TreeNode?): Int {
        if (root == null)
            return 0

        return maxSum(root)[0]
    }

    // return [maxOfAll, maxAsRoot]
    private fun maxSum(node: TreeNode?): IntArray {
        if (node == null)
            return intArrayOf(Int.MIN_VALUE, 0)

        val nodeValue = node.`val`
        val leftSum = maxSum(node.left)
        val rightSum = maxSum(node.right)
        val leftContribute = maxOf(0, leftSum[1])
        val rightContribute = maxOf(0, rightSum[1])
        val maxOfAll = maxOf(nodeValue + leftContribute + rightContribute, leftSum[0], rightSum[0])
        val maxAsRoot = nodeValue + maxOf( + leftContribute, rightContribute)

        return intArrayOf(maxOfAll, maxAsRoot)
    }
}