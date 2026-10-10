package com.leishou.solution

/*
    A transformation sequence from word beginWord to word endWord using a dictionary wordList is
    a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:

    Every adjacent pair of words differs by a single letter.
    Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
    sk == endWord
    Given two words, beginWord and endWord, and a dictionary wordList, return all the shortest
    transformation sequences from beginWord to endWord, or an empty list if no such sequence exists.
    Each sequence should be returned as a list of the words [beginWord, s1, s2, ..., sk].

    1 <= beginWord.length <= 5
    endWord.length == beginWord.length
    1 <= wordList.length <= 500
    wordList[i].length == beginWord.length
    beginWord, endWord, and wordList[i] consist of lowercase English letters.
    beginWord != endWord
    All the words in wordList are unique.
    The sum of all shortest transformation sequences does not exceed 105.
 */
class WordLadderII {
    fun findLadders(beginWord: String, endWord: String, wordList: List<String>): List<List<String>> {
        if (endWord !in wordList)
            return emptyList()

        val unvisitedWords = wordList.toMutableList()
        val beginNode = WordNode(beginWord)
        val endNode = WordNode(endWord)
        unvisitedWords.remove(endWord)
        var beginFrontier = mutableListOf(beginNode)
        var endFrontier =  mutableListOf(endNode)
        var currentFrontier: MutableList<WordNode>
        var oppositeFrontier: MutableList<WordNode>
        var expandingFromBegin: Boolean
        val result = mutableListOf<List<String>>()
        outer@ while (beginFrontier.isNotEmpty() && endFrontier.isNotEmpty()) {
            if (beginFrontier.size > endFrontier.size) {
                currentFrontier = endFrontier
                oppositeFrontier = beginFrontier
                expandingFromBegin = false
            } else {
                currentFrontier = beginFrontier
                oppositeFrontier = endFrontier
                expandingFromBegin = true
            }

            for (currentNode in currentFrontier) {
                for (oppositeNode in oppositeFrontier) {
                    if (isOneLetterDiff(currentNode.word, oppositeNode.word)) {
                        val sourceList =
                            if (expandingFromBegin)
                                buildPathsToWord(beginNode, currentNode.word)
                            else buildPathsToWord(beginNode, oppositeNode.word)
                        val targetList =
                            if (expandingFromBegin)
                                buildPathsToWord(endNode, oppositeNode.word)
                            else buildPathsToWord(endNode, currentNode.word)
                        result.addAll(combinePaths(sourceList, targetList))
                    }
                }
            }

            if (result.isNotEmpty()) {
                break@outer
            }

            val nextFrontier = mutableListOf<WordNode>()
            val nextFrontierWordsSet = mutableSetOf<String>()
            for (currentNode in currentFrontier) {
                for (candidateWord in unvisitedWords) {
                    if (isOneLetterDiff(currentNode.word, candidateWord)) {
                        val nextNode = WordNode(candidateWord)
                        currentNode.next.add(nextNode)
                        if (nextFrontierWordsSet.add(candidateWord)) {
                            nextFrontier.add(nextNode)
                        }
                    }
                }
            }

            unvisitedWords.removeAll(nextFrontierWordsSet)
            if (expandingFromBegin) {
                beginFrontier = nextFrontier
            } else {
                endFrontier = nextFrontier
            }
        }

        return result
    }

    private fun buildPathsToWord(node: WordNode, target: String): List<List<String>> {
        val result = mutableListOf<List<String>>()
        val path = mutableListOf<String>()
        fun dfs(n: WordNode) {
            if (n.word == target) {
                path.add(target)
                result.add(path.toMutableList())
                path.removeLast()
                return
            }

            path.add(n.word)
            for (next in n.next) {
                dfs(next)
            }
            path.removeLast()
        }

        dfs(node)
        return result
    }

    private fun combinePaths(pathsFromBegin: List<List<String>>,
                             pathsFromEnd: List<List<String>>): List<List<String>> {
        val result = mutableListOf<List<String>>()
        for (beginPath in pathsFromBegin) {
            for (endPath in pathsFromEnd) {
                val combinedPath = beginPath.toMutableList()
                for (i in endPath.lastIndex downTo 0) {
                    combinedPath.add(endPath[i])
                }
                result.add(combinedPath)
            }
        }

        return result
    }

    private fun isOneLetterDiff(word1: String, word2: String): Boolean {
        var diffCount = 0
        for (i in word1.indices) {
            if (word1[i] != word2[i])
                diffCount++

            if (diffCount > 1)
                return false
        }

        return diffCount == 1
    }

    class WordNode(val word: String) {
        val next = mutableListOf<WordNode>()
    }
}