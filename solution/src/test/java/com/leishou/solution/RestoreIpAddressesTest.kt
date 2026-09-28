package com.leishou.solution

import org.junit.Test
import kotlin.test.assertEquals

class RestoreIpAddressesTest {
    @Test
    fun testExample1() {
        val sol = RestoreIpAddresses()
        assertEquals(listOf("255.255.11.135", "255.255.111.35"), sol.restoreIpAddresses("25525511135"))
    }

    @Test
    fun testExample2() {
        val sol = RestoreIpAddresses()
        assertEquals(listOf("0.0.0.0"), sol.restoreIpAddresses("0000"))
    }

    @Test
    fun testExample3() {
        val sol = RestoreIpAddresses()
        assertEquals(listOf("1.0.10.23", "1.0.102.3", "10.1.0.23", "10.10.2.3", "101.0.2.3"), sol.restoreIpAddresses("101023"))
    }
}