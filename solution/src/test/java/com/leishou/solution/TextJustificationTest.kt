package com.leishou.solution

import org.junit.Test
import kotlin.test.assertContentEquals

class TextJustificationTest {
    @Test
    fun testExample1() {
        val sol = TextJustification()
        val ret = sol.fullJustify(arrayOf("This", "is", "an", "example", "of", "text", "justification."), 16)
        assertContentEquals(listOf(
            "This    is    an",
            "example  of text",
            "justification.  "), ret)
    }

    @Test
    fun testExample2() {
        val sol = TextJustification()
        val ret = sol.fullJustify(arrayOf("What","must","be","acknowledgment","shall","be"), 16)
        assertContentEquals(listOf(
            "What   must   be",
            "acknowledgment  ",
            "shall be        "), ret)
    }

    @Test
    fun testExample3() {
        val sol = TextJustification()
        val ret = sol.fullJustify(arrayOf("Science", "is", "what", "we", "understand", "well", "enough",
            "to", "explain", "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do"), 20)
        assertContentEquals(listOf(
            "Science  is  what we",
            "understand      well",
            "enough to explain to",
            "a  computer.  Art is",
            "everything  else  we",
            "do                  "), ret)
    }

    @Test
    fun testExample4() {
        val sol = TextJustification()
        val ret = sol.fullJustify(arrayOf("ask", "not", "what", "your", "country", "can", "do", "for",
            "you", "ask", "what", "you", "can", "do", "for", "your", "country"), 16)
        assertContentEquals(listOf(
            "ask   not   what",
            "your country can",
            "do  for  you ask",
            "what  you can do",
            "for your country"), ret)
    }
}