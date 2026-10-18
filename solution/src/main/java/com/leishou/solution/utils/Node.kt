package com.leishou.solution.utils

/*
    For simplicity, each node's value is the same as the node's index (1-indexed). For example,
    the first node with val == 1, the second node with val == 2, and so on.
    The graph is represented in the test case using an adjacency list.

    An adjacency list is a collection of unordered lists used to represent a finite graph.
    Each list describes the set of neighbors of a node in the graph.

    The given node will always be the first node with val = 1. You must return the copy of the
    given node as a reference to the cloned graph.
 */
class Node(var `val`: Int) {
    var neighbors: ArrayList<Node?> = ArrayList()
    fun neighboursList() = mutableListOf<Int>().apply {
        for (n in neighbors) {
            n?.let {
                add(it.`val`)
            }
        }
    }

    companion object {
        fun listToNode(list: List<List<Int>>): Node? {
            val map = HashMap<Int, Node>()
            for (i in list.indices) {
                val l = list[i]
                val value = i + 1
                val node = map.getOrPut(value) { Node(value) }
                map[value] = node
                for (neighbor in l) {
                    val neighborNode = map.getOrPut(neighbor) { Node(neighbor) }
                    node.neighbors.add(neighborNode)
                }
            }

            return map[1]
        }

        fun nodeToList(node: Node?): List<List<Int>> {
            if (node?.`val` != 1)
                return emptyList()

            val visited = mutableSetOf<Int>()
            val queue = ArrayDeque<Node>()
            queue.addLast(node)
            visited.add(node.`val`)
            val result = mutableListOf<List<Int>>()
            while (queue.isNotEmpty()) {
                val current = queue.removeFirst()
                val index = current.`val` - 1
                while (result.size <= index) {
                    result.add(emptyList())
                }
                result[index] = current.neighboursList()
                for (n in current.neighbors) {
                    n?.let {
                        if (visited.add(n.`val`)) {
                            queue.addLast(n)
                        }
                    }
                }
            }

            return result
        }
    }
}