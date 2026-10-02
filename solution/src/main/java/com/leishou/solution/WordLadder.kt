package com.leishou.solution

/*
    A transformation sequence from word beginWord to word endWord using a dictionary wordList is
    a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:
    1, Every adjacent pair of words differs by a single letter.
    2, Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
    3, sk == endWord

    Given two words, beginWord and endWord, and a dictionary wordList, return the number of
    words in the shortest transformation sequence from beginWord to endWord, or 0 if no such sequence
    exists.

    Constraints:
    1 <= beginWord.length <= 10
    endWord.length == beginWord.length
    1 <= wordList.length <= 5000
    wordList[i].length == beginWord.length
    beginWord, endWord, and wordList[i] consist of lowercase English letters.
    beginWord != endWord
    All the words in wordList are unique
 */
class WordLadder {
    fun ladderLength(beginWord: String, endWord: String, wordList: List<String>): Int {
        // To check if a neighbour word exists
        // 1: list iterates and compares, O(NL) (N: words count, L: word length)
        // 2: set.contain(), go through all available neighbour, O(26*10*L) (max word length 10)
        if (endWord !in wordList)
            return 0

        val n = wordList.size
        val length = beginWord.length
        return if (26 * length > n) {
            ladderLengthWithLittleNum(beginWord, endWord, wordList)
        } else {
            ladderLengthWithLargeNum(beginWord, endWord, wordList)
        }
    }

    private fun ladderLengthWithLittleNum(beginWord: String, endWord: String, wordList: List<String>): Int {
        var ret = 2
        var expandSet = mutableSetOf(beginWord)
        var compareSet = mutableSetOf(endWord)
        val mutableList = wordList.toMutableList() // use list as list have a good iteration efficiency
        while (expandSet.isNotEmpty() && compareSet.isNotEmpty()) {
            // expand small size will be much more efficient
            if (expandSet.size > compareSet.size) {
                val temp = expandSet
                expandSet = compareSet
                compareSet = temp
            }

            val next = mutableSetOf<String>()
            for (key in expandSet) {
                for (word in compareSet) {
                    if (isOneLetterDiff(key, word)) {
                        return ret
                    }
                }

                for (word in mutableList) {
                    if (isOneLetterDiff(key, word)) {
                        next.add(word)
                    }
                }
            }

            mutableList.removeAll(next)
            expandSet = next
            ret++
        }

        return 0
    }

    private fun ladderLengthWithLargeNum(beginWord: String, endWord: String, wordList: List<String>): Int {
        var ret = 2
        var expandSet = mutableSetOf(beginWord)
        var compareSet = mutableSetOf(endWord)
        val wordSet = wordList.toMutableSet()
        while (expandSet.isNotEmpty() && compareSet.isNotEmpty()) {
            // expand small size will be much more efficient
            if (expandSet.size > compareSet.size) {
                val temp = expandSet
                expandSet = compareSet
                compareSet = temp
            }

            val next = mutableSetOf<String>()
            for (key in expandSet) {
                val chars = key.toCharArray()
                for (i in key.indices) {
                    val original = key[i]
                    for (c in 'a'..'z') {
                        if (c == original)
                            continue

                        chars[i] = c
                        val neighbour = String(chars)
                        if (compareSet.contains(neighbour)) {
                            return ret
                        }

                        if (wordSet.contains(neighbour)) {
                            next.add(neighbour)
                            wordSet.remove(neighbour)
                        }
                    }
                    chars[i] = original
                }
            }

            expandSet = next
            ret++
        }

        return 0
    }

    private fun isOneLetterDiff(word1: String, word2: String): Boolean {
        var diff = 0
        for (i in word1.indices) {
            if (word1[i] != word2[i])
                diff++

            if (diff > 1) {
                return false
            }
        }

        return diff == 1
    }

    // build graph way
    fun ladderLength_(beginWord: String, endWord: String, wordList: List<String>): Int {
        if (endWord !in wordList)
            return 0

        val n = wordList.size
        var target: Int? = null
        // set beginning word as 0
        val graph = Array(n + 1) {
            BooleanArray(n  + 1) { false }
        }

        // build a graph
        for (i in wordList.indices) {
            if (isOneLetterDiff(beginWord, wordList[i])) {
                graph[0][i + 1] = true
                graph[i + 1][0] = true
            }

            if (target == null) {
                if (wordList[i] == endWord) {
                    target = i + 1
                    if (graph[target][0]) {
                        return 2
                    }
                }
            }

            for (j in wordList.indices) {
                if (i == j) continue
                if (isOneLetterDiff(wordList[i], wordList[j])) {
                    graph[i + 1][j + 1] = true
                    graph[j + 1][i + 1] = true
                }
            }
        }

        var beginTree = mutableSetOf<Int>()
        beginTree.add(0)
        var endTree = mutableSetOf<Int>()
        endTree.add(target!!)

        val visiting = IntArray(n + 1) { 0 } // 0: unvisited 1: begin visiting 2: end visiting
        visiting[0] = 1
        visiting[target] = 2
        var isBeginExpand: Boolean
        var ret = 2
        outerLoop@ while (true) {
            isBeginExpand = beginTree.size <= endTree.size
            val expand = if (isBeginExpand) beginTree else endTree
            if (expand.size == 0) {
                ret = 0
                break
            }

            val temp = mutableSetOf<Int>()
            for (i in expand) {
                for (j in 1..n) {
                    if (graph[i][j]) {
                        if (isBeginExpand) {
                            if (visiting[j] and 2 != 0) {
                                break@outerLoop
                            }

                            if (visiting[j] and 1 == 0) {
                                temp.add(j)
                                visiting[j] = visiting[j] or 1
                            }
                        } else {
                            if (visiting[j] and 1 != 0) {
                                break@outerLoop
                            }

                            if (visiting[j] and 2 == 0) {
                                temp.add(j)
                                visiting[j] = visiting[j] or 2
                            }
                        }
                    }
                }
            }

            if (isBeginExpand) {
                beginTree = temp
            } else {
                endTree = temp
            }

            ret++
        }

        return ret
    }
}