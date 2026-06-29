package com.leishou.solution.utils

class WordDictionary {
    private val root = TrieNode()

    fun insert(word: String) {
        var node: TrieNode = root
        for (char in word) {
            val index = char - 'a'
            if (node.children[index] == null) {
                node.children[index] = TrieNode()
            }

            node = node.children[index]!!
        }

        node.isEnd = false
    }

    fun insertWordRecv(word: String) {
        val length = word.length
        for (i in 0 until length) {
            var node = root
            for (j in i until length) {
                val c = word[j] - 'a'
                if (node.children[c] == null) {
                    node.children[c] = TrieNode()
                }

                node = node.children[c]!!
            }
        }
    }

    fun search(word: String): Boolean {
        return dfs(word, root, 0)
    }

    private fun dfs(word: String, node: TrieNode, index: Int): Boolean {
        if (index == word.length)
            return node.isEnd

        val i = word[index] - 'a'
        if (node.children[i] == null) {
            return false
        }

        return dfs(word, node.children[i]!!, index + 1)
    }
}