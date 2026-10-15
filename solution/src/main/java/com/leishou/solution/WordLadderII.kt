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

        val unvisitedWords = wordList.toMutableSet()
        unvisitedWords.remove(beginWord)
        unvisitedWords.remove(endWord)
        var beginFrontier = mutableListOf(beginWord)
        var endFrontier =  mutableListOf(endWord)
        var frontier: MutableList<String>
        var oppositeFrontier: MutableList<String>
        var isExpandingFromBegin: Boolean
        val allShortestPaths = mutableListOf<List<String>>()
        val pathsByWord = mutableMapOf<String, MutableList<List<String>>>()
        val predecessorsByWord = mutableMapOf<String, MutableList<String>>()
        // All path is from mid to begin / end
        fun buildPathsToRoot(targetWord: String): List<List<String>> {
            if (pathsByWord[targetWord]?.isNotEmpty() == true)
                return pathsByWord[targetWord]!!

            if (predecessorsByWord[targetWord].isNullOrEmpty()) {
                val paths = mutableListOf(listOf(targetWord))
                pathsByWord[targetWord] = paths
                return paths
            }

            val paths = mutableListOf<List<String>>()
            for (predecessor in predecessorsByWord[targetWord]!!) {
                val predecessorPaths = buildPathsToRoot(predecessor)
                val reversedBeginPath = mutableListOf<String>()
                reversedBeginPath.add(targetWord)
                for (path in predecessorPaths) {
                    val combinedPath = reversedBeginPath.toMutableList()
                    combinedPath.addAll(path)
                    paths.add(combinedPath)
                }
            }

            pathsByWord[targetWord] = paths
            return paths
        }

        outer@ while (beginFrontier.isNotEmpty() && endFrontier.isNotEmpty()) {
            if (beginFrontier.size > endFrontier.size) {
                frontier = endFrontier
                oppositeFrontier = beginFrontier
                isExpandingFromBegin = false
            } else {
                frontier = beginFrontier
                oppositeFrontier = endFrontier
                isExpandingFromBegin = true
            }

            for (currentWord in frontier) {
                for (oppositeWord in oppositeFrontier) {
                    if (isOneLetterDiff(currentWord, oppositeWord)) {
                        val beginSideWord = if (isExpandingFromBegin) currentWord else oppositeWord
                        val pathsFromBegin = buildPathsToRoot(beginSideWord)
                        val endSideWord = if (isExpandingFromBegin) oppositeWord else currentWord
                        val pathsFromEnd = buildPathsToRoot(endSideWord)
                        allShortestPaths.addAll(combinePaths(pathsFromBegin, pathsFromEnd))
                    }
                }
            }

            if (allShortestPaths.isNotEmpty()) {
                break@outer
            }

            val nextFrontier = mutableListOf<String>()
            // using a map to make sure every word node is unique
            for (currentWord in frontier) {
                for (candidateWord in unvisitedWords) {
                    if (isOneLetterDiff(currentWord, candidateWord)) {
                        val predecessors = predecessorsByWord.getOrPut(candidateWord) {
                            nextFrontier.add(candidateWord)
                            mutableListOf()
                        }
                        predecessors.add(currentWord)
                    }
                }
            }

            unvisitedWords.removeAll(nextFrontier.map { it }.toSet())
            if (isExpandingFromBegin) {
                beginFrontier = nextFrontier
            } else {
                endFrontier = nextFrontier
            }
        }

        return allShortestPaths
    }

    private fun combinePaths(pathsFromBegin: List<List<String>>,
                             pathsFromEnd: List<List<String>>): List<List<String>> {
        val result = mutableListOf<List<String>>()
        for (beginPath in pathsFromBegin) {
            val combined = mutableListOf<String>()
            for (i in beginPath.lastIndex downTo 0) {
                combined.add(beginPath[i])
            }

            for (endPath in pathsFromEnd) {
                val mergedPath = combined.toMutableList()
                mergedPath.addAll(endPath)
                result.add(mergedPath)
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
}