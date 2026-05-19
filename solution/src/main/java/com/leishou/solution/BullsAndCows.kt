package com.leishou.solution

import kotlin.math.min

class BullsAndCows {
    fun getHint(secret: String, guess: String): String {
        val secretArray = IntArray(10)
        val guessArray = IntArray(10)
        var bulls = 0
        var total = 0
        val guessLen = guess.length
        val secretLen = secret.length
        for (i in secret.indices) {
            val s = secret[i]
            secretArray[s - '0'] = secretArray[s - '0'] + 1
            if (i < guessLen) {
                val g = guess[i]
                guessArray[g - '0'] = guessArray[g - '0'] + 1
                if (s == g) bulls++
            }
        }

        for (i in secretLen until guessLen) {
            val g = guess[i]
            guessArray[g - '0'] = guessArray[g - '0'] + 1
        }

        for (i in 0 until 10) {
            total += min(guessArray[i], secretArray[i])
        }

        return "${bulls}A${total - bulls}B"
    }
}