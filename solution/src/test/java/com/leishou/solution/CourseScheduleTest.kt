package com.leishou.solution

import org.junit.Test
import kotlin.test.assertEquals

class CourseScheduleTest {
    @Test
    fun testExample1() {
        assertEquals(true, CourseSchedule().canFinish(2, arrayOf(intArrayOf(1, 0))))
    }

    @Test
    fun testExample2() {
        assertEquals(false, CourseSchedule().canFinish(2, arrayOf(intArrayOf(1, 0), intArrayOf(0, 1))))
    }

    @Test
    fun testExample3() {
        assertEquals(true, CourseSchedule().canFinish(5,
            arrayOf(intArrayOf(1, 4), intArrayOf(2, 4), intArrayOf(3, 1), intArrayOf(3, 2))))
    }
}