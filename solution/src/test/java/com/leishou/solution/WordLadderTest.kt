package com.leishou.solution

import org.junit.Test
import kotlin.test.assertEquals

class WordLadderTest {
    @Test
    fun testExample1() {
        val wordList = arrayListOf("hot", "dot", "dog", "lot", "log", "cog")
        assertEquals(5, WordLadder().ladderLength("hit", "cog", wordList))
    }

    @Test
    fun testExample2() {
        val wordList = arrayListOf("hot", "dot", "dog", "lot", "log")
        assertEquals(0, WordLadder().ladderLength("hit", "cog", wordList))
    }

    @Test
    fun testExample3() {
        val wordList = arrayListOf("a", "b", "c")
        assertEquals(2, WordLadder().ladderLength("a", "c", wordList))
    }

    @Test
    fun testExample4() {
        val wordList = arrayListOf("si", "go", "se", "cm", "so", "ph", "mt", "db", "mb", "sb", "kr",
            "ln", "tm", "le", "av", "sm", "ar", "ci", "ca", "br", "ti", "ba", "to", "ra", "fa", "yo",
            "ow", "sn", "ya", "cr", "po", "fe", "ho", "ma", "re", "or", "rn", "au", "ur", "rh", "sr",
            "tc", "lt", "lo", "as", "fr", "nb", "yb", "if", "pb", "ge", "th", "pm", "rb", "sh", "co",
            "ga", "li", "ha", "hz", "no", "bi", "di", "hi", "qa", "pi", "os", "uh", "wm", "an", "me",
            "mo", "na", "la", "st", "er", "sc", "ne", "mn", "mi", "am", "ex", "pt", "io", "be", "fm",
            "ta", "tb", "ni", "mr", "pa", "he", "lr", "sq", "ye")
        assertEquals(5, WordLadder().ladderLength("qa", "sq", wordList))
    }

    @Test
    fun testExample5() {
        val wordList = arrayListOf("aaa", "aab", "aac", "aca", "acc", "baa", "bbc", "bca", "bcc", "ccb")
        assertEquals(5, WordLadder().ladderLength("aba", "bbc", wordList))
    }

    @Test
    fun testExample6() {
        val wordList = arrayListOf("hot", "dog")
        assertEquals(0, WordLadder().ladderLength("hot", "dog", wordList))
    }
}