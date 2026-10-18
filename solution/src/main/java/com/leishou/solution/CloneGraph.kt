package com.leishou.solution

import com.leishou.solution.utils.Node

/*
    Given a reference of a node in a connected undirected graph.
    Return a deep copy (clone) of the graph.

    Each node in the graph contains a value (int) and a list (List[Node]) of its neighbors.

    The number of nodes in the graph is in the range [0, 100].
    1 <= Node.val <= 100
    Node.val is unique for each node.
    There are no repeated edges and no self-loops in the graph.
    The Graph is connected and all nodes can be visited starting from the given node.
 */
class CloneGraph {
    fun cloneGraph(node: Node?): Node? {
        if (node == null)
            return null

        val queue = ArrayDeque<Node>()
        val nodeMap = HashMap<Int, Node>()
        val nodeValue = node.`val`
        nodeMap[nodeValue] = Node(nodeValue)
        queue.addLast(node)
        while (queue.isNotEmpty()) {
            val current = queue.removeFirst()
            val newNode = nodeMap[current.`val`]

            for (n in current.neighbors) {
                n?.let {
                    newNode!!.neighbors.add(nodeMap.getOrPut(n.`val`) {
                        queue.addLast(n)
                        Node(n.`val`)
                    })
                }
            }
        }

        return nodeMap[nodeValue]
    }
}