package com.leishou.solution

import org.junit.Test
import kotlin.test.assertEquals

class SimplifyPathTest {
    @Test
    fun testExample1() {
        val sol = SimplifyPath()
        val path = "/home/"
        val expected = "/home"
        assertEquals(expected, sol.simplifyPath(path))
    }

    @Test
    fun testExample2() {
        val sol = SimplifyPath()
        val path = "/home//foo/"
        val expected = "/home/foo"
        assertEquals(expected, sol.simplifyPath(path))
    }

    @Test
    fun testExample3() {
        val sol = SimplifyPath()
        val path = "/home/user/Documents/../Pictures"
        val expected = "/home/user/Pictures"
        assertEquals(expected, sol.simplifyPath(path))
    }

    @Test
    fun testExample4() {
        val sol = SimplifyPath()
        val path = "/.../a/../b/c/../d/./"
        val expected = "/.../b/d"
        assertEquals(expected, sol.simplifyPath(path))
    }

    @Test
    fun testExample5() {
        val sol = SimplifyPath()
        val path = "/../"
        val expected = "/"
        assertEquals(expected, sol.simplifyPath(path))
    }
}