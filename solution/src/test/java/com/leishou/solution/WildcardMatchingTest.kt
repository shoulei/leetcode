package com.leishou.solution

import org.junit.Test
import kotlin.test.assertEquals

class WildcardMatchingTest {
    @Test
    fun testExample1() {
        val sol = WildcardMatching()
        assertEquals(true, sol.isMatch("aa", "*"))
    }

    @Test
    fun testExample2() {
        val sol = WildcardMatching()
        assertEquals(false, sol.isMatch("aa", "a"))
    }

    @Test
    fun testExample3() {
        val sol = WildcardMatching()
        assertEquals(false, sol.isMatch("cb", "?a"))
    }

    @Test
    fun testExample4() {
        val sol = WildcardMatching()
        assertEquals(false, sol.isMatch("mississippi", "m??*ss*?i*pi"))
    }
}