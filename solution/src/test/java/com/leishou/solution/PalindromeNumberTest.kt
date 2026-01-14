package com.leishou.solution

import org.junit.Test
import kotlin.test.assertEquals


/*
    Given an integer x, return true if x is a palindrome, and false otherwise.
 */
class PalindromeNumberTest {
    @Test
    fun testExample1() {
        val sol = PalindromeNumber()
        val result = sol.isPalindrome(131)
        assertEquals(result, true)
    }

    @Test
    fun testExample2() {
        val sol = PalindromeNumber()
        val result = sol.isPalindrome(-121)
        assertEquals(result, false)
    }

    @Test
    fun testExample3() {
        val sol = PalindromeNumber()
        val result = sol.isPalindrome(10)
        assertEquals(result, false)
    }

    @Test
    fun testExample4() {
        val sol = PalindromeNumber()
        val result = sol.isPalindrome(120030221)
        assertEquals(result, false)
    }

    @Test
    fun testExample5() {
        val sol = PalindromeNumber()
        val result = sol.isPalindrome(1000110001)
        assertEquals(result, true)
    }

    @Test
    fun testExample6() {
        val sol = PalindromeNumber()
        val result = sol.isPalindrome(1)
        assertEquals(result, true)
    }

    @Test
    fun testExample7() {
        val sol = PalindromeNumber()
        val result = sol.isPalindrome(0)
        assertEquals(result, true)
    }
}