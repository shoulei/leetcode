package com.leishou.solution

import org.junit.Test
import kotlin.test.assertContentEquals

class SubstringOfAllWordsTest {
    @Test
    fun testExample1() {
        val sol = SubstringOfAllWords()
        val ret = sol.findSubstring("barfoothefoobarman", arrayOf("foo", "bar"))
        assertContentEquals(ret.toIntArray(), intArrayOf(0, 9))
    }

    @Test
    fun testExample2() {
        val sol = SubstringOfAllWords()
        val ret = sol.findSubstring("barfoofoobarthefoobarman", arrayOf("bar", "foo", "the"))
        assertContentEquals(ret.toIntArray(), intArrayOf(6, 9, 12))
    }

    @Test
    fun testExample3() {
        val sol = SubstringOfAllWords()
        val ret = sol.findSubstring("wordgoodgoodgoodbestword", arrayOf("word","good","best","word"))
        assertContentEquals(ret.toIntArray(), intArrayOf())
    }
}