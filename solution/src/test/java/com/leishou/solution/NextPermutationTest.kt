package com.leishou.solution

import org.junit.Test
import kotlin.test.assertContentEquals

class NextPermutationTest {
    @Test
    fun testExample1() {
        val array = intArrayOf(1, 2, 3)
        NextPermutation().nextPermutation(array)
        assertContentEquals(intArrayOf(1, 3, 2), array)
    }

    @Test
    fun testExample2() {
        val array = intArrayOf(3, 2, 1)
        NextPermutation().nextPermutation(array)
        assertContentEquals(intArrayOf(1, 2, 3), array)
    }

    @Test
    fun testExample3() {
        val array = intArrayOf(1, 1, 5)
        NextPermutation().nextPermutation(array)
        assertContentEquals(intArrayOf(1, 5, 1), array)
    }

    @Test
    fun testExample4() {
        val array = intArrayOf(1, 3, 2)
        NextPermutation().nextPermutation(array)
        assertContentEquals(intArrayOf(2, 1, 3), array)
    }

    @Test
    fun testExample5() {
        val array = intArrayOf(2, 3, 1)
        NextPermutation().nextPermutation(array)
        assertContentEquals(intArrayOf(3, 1, 2), array)
    }

    @Test
    fun testExample6() {
        val array = intArrayOf(2, 3, 1, 3, 3)
        NextPermutation().nextPermutation(array)
        assertContentEquals(intArrayOf(2, 3, 3, 1, 3), array)
    }
}