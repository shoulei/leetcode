package com.leishou.solution


/*
    You are given an integer array arr of length n that represents a permutation of the integers
     in the range [0, n - 1].

    We split arr into some number of chunks (i.e., partitions), and individually sort each chunk.
    After concatenating them, the result should equal the sorted array.

    Return the largest number of chunks we can make to sort the array.

    n == arr.length
    1 <= n <= 10
    0 <= arr[i] < n
    All the elements of arr are unique.
 */
class MaxChunksToMakeSorted {
    fun maxChunksToSorted(arr: IntArray): Int {
        val n = arr.size
        var chunkCount = 0
        var chunkStart = 0
        var expectedMin = 0
        while (chunkStart < n) {
            var containsExpectedMin = false
            var maxInChunk = -1
            for (i in chunkStart until n) {
                maxInChunk = maxOf(maxInChunk, arr[i])
                if (arr[i] == expectedMin) {
                    containsExpectedMin = true
                }

                if (containsExpectedMin && maxInChunk - expectedMin == i - chunkStart) {
                    chunkCount++
                    chunkStart = i + 1
                    expectedMin = maxInChunk + 1
                    break
                }
            }
        }

        return chunkCount
    }
}