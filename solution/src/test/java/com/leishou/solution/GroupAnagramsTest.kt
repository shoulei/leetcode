package com.leishou.solution

import org.junit.Test
import kotlin.test.assertEquals

class GroupAnagramsTest {
    @Test
    fun testExample1() {
        val result = GroupAnagrams().groupAnagrams(arrayOf("eat", "tea", "tan", "ate", "nat", "bat"))
        val expected = listOf(listOf("bat"), listOf("nat", "tan"), listOf("ate", "eat", "tea"))
        assertEquals(expected.map { it.sorted() }.sortedBy { it.toString() }, result.map { it.sorted() }.sortedBy { it.toString() })
    }

    @Test
    fun testExample2() {
        val result = GroupAnagrams().groupAnagrams(arrayOf("a"))
        val expected = listOf(listOf("a"))
        assertEquals(expected.map { it.sorted() }.sortedBy { it.toString() }, result.map { it.sorted() }.sortedBy { it.toString() })
    }

    @Test
    fun testExample3() {
        val result = GroupAnagrams().groupAnagrams(arrayOf(""))
        val expected = listOf(listOf(""))
        assertEquals(expected.map { it.sorted() }.sortedBy { it.toString() }, result.map { it.sorted() }.sortedBy { it.toString() })
    }
}