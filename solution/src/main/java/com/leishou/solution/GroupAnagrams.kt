package com.leishou.solution

/*
    Given an array of strings strs, group the anagrams together. You can return the answer in any order.
    An anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
    using all the original letters exactly once.

    1 <= strs.length <= 104
    0 <= strs[i].length <= 100
    strs[i] consists of lowercase English letters.
 */
class GroupAnagrams {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val map = HashMap<String, MutableList<String>>()
        for (string in strs) {
            val sortedString = string.toCharsCountKey()
            map.getOrPut(sortedString) {
                mutableListOf()
            }.add(string)
        }

        return map.values.toList()
    }

    private fun String.toCharsCountKey(): String {
        val chars = CharArray(26)
        for (c in this) {
            chars[c - 'a']++
        }

        return String(chars)
    }
}