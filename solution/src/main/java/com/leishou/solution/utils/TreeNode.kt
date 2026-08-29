package com.leishou.solution.utils

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null

    companion object {
        fun listToTreeNode(nums: List<Int?>): TreeNode? {
            if (nums.isEmpty() || nums[0] == null)
                return null

            val length = nums.size
            val root = TreeNode(nums[0]!!)
            val queue = ArrayDeque<TreeNode>()
            queue.add(root)
            var index = 1
            while (index < length && queue.isNotEmpty()) {
                val parent = queue.removeFirst()
                nums[index++]?.let {
                    val node = TreeNode(it)
                    parent.left = node
                    queue.add(node)
                }

                if (index < length) {
                    nums[index++]?.let {
                        val node = TreeNode(it)
                        parent.right = node
                        queue.add(node)
                    }
                }
            }

            return root
        }
    }
}