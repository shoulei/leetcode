package com.leishou.solution

class WordFilter(words: Array<String>) {
    private var normalRoot: TrieNode
    private var reversedRoot: TrieNode
    init {
        normalRoot = TrieNode()
        reversedRoot = TrieNode()
        for (i in words.indices) {
            normalRoot.insertWord(words[i], i)
            reversedRoot.insertWord(words[i], i, false)
        }
    }

    fun f(pref: String, suff: String): Int {
        val prefList = normalRoot.search(pref)
        val suffList = reversedRoot.search(suff, false)
        var i = prefList.size - 1
        var j = suffList.size - 1
        while (i >= 0 && j >= 0) {
            when {
                prefList[i] > suffList[j] -> i--
                prefList[i] == suffList[j] -> return prefList[i]
                else -> j--
            }
        }

        return -1
    }

    class TrieNode {
        private val children = Array<TrieNode?>(26) { null }
        private var wordIndices = mutableListOf<Int>() // index is in order already here

        fun insertWord(word: String, index: Int, normalOrder: Boolean = true) {
            val last = word.length - 1
            var node = this
            node.wordIndices.add(index)
            for (position in word.indices) {
                val c = if (normalOrder) word[position] else word[last - position]
                val i = c - 'a'
                if (node.children[i] == null) {
                    node.children[i] = TrieNode()
                }

                node = node.children[i]!!
                node.wordIndices.add(index)
            }
        }

        fun search(key: String, normalOrder: Boolean = true): List<Int> {
            val ret = dfs(key, this, 0, normalOrder)
            return ret?.wordIndices?: emptyList()
        }

        private fun dfs(key: String, node: TrieNode, i: Int, normalOrder: Boolean = true): TrieNode? {
            val n = key.length
            if (i == n)
                return node

            val c = if (normalOrder) key[i] else key[n - i - 1]
            val child = node.children[c - 'a'] ?: return null

            return dfs(key, child, i + 1, normalOrder)
        }
    }
}