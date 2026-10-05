package com.leishou.solution

import org.junit.Test
import kotlin.test.assertEquals

class DistinctSubsequencesTest {
    @Test
    fun testExample1() {
        assertEquals(700531452, DistinctSubsequences().numDistinct(
            "adbdadeecadeadeccaeaabdabdbcdabddddabcaaadbabaaedeeddeaeebcdeabcaaaeeaeeabcddcebdd" +
                    "ebeebedaecccbdcbcedbdaeaedcdebeecdaaedaacadbdccabddaddacdddc",
            "bcddceeeebecbc"))
    }

    @Test
    fun testExample2() {
        assertEquals(3, DistinctSubsequences().numDistinct("rabbbit", "rabbit"))
    }

    @Test
    fun testExample3() {
        assertEquals(5, DistinctSubsequences().numDistinct("babgbag", "bag"))
    }
}