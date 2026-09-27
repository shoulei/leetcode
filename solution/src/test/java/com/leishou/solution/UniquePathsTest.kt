package com.leishou.solution

import org.junit.Test
import kotlin.test.assertEquals

class UniquePathsTest {
    @Test
    fun testExample1() {
        assertEquals(28, UniquePaths().uniquePaths(3, 7))
    }

    @Test
    fun testExample2() {
        assertEquals(3, UniquePaths().uniquePaths(3, 2))
    }
}