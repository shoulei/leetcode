package com.leishou.solution.utils

class TrieNode {
    val children = Array<TrieNode?>(26) { null }
    var isEnd = false
}