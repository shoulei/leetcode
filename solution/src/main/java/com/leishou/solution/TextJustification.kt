package com.leishou.solution

class TextJustification {
    fun fullJustify(words: Array<String>, maxWidth: Int): List<String> {
        val ret = mutableListOf<String>()
        val sb = StringBuilder(maxWidth)
        val allWordsCt = words.size
        var start = 0
        var end = 0
        while (start < allWordsCt) {
            var lineLen = 0
            var lettersLen = 0
            for (i in start until allWordsCt) {
                lineLen += words[i].length
                if (lineLen > maxWidth) {
                    end = i
                    break
                }

                lettersLen += words[i].length
                end = i + 1
                lineLen++
            }

            ret.add(buildLine(words, maxWidth, lettersLen, start, end, sb))
            start = end
        }

        return ret
    }

    // end is exclusive
    private fun buildLine(words: Array<String>, maxWidth: Int, lettersLen: Int, start: Int, end: Int, sb: StringBuilder): String {
        sb.clear()
        val gap = end - start - 1
        val totalSpace = maxWidth - lettersLen
        val isLastLine = end == words.size

        if (gap == 0 || isLastLine) {
            for (i in start until end) {
                sb.append(words[i])
                sb.append(' ')
            }

            val rest = maxWidth - sb.length
            if (rest > 0) {
                repeat(rest) {
                    sb.append(' ')
                }
            } else if (rest == -1) { // to remove a extra space in last
                sb.deleteAt(sb.length - 1)
            }

            return sb.toString()
        } else {
            val averageSpaces = totalSpace / gap
            val widerCt = totalSpace % gap
            sb.append(words[start])
            for ((widerIndex, i) in (start + 1 until end).withIndex()) {
                val repeat = if (widerIndex < widerCt) averageSpaces + 1 else averageSpaces
                repeat(repeat) {
                    sb.append(' ')
                }
                sb.append(words[i])
            }

            return sb.toString()
        }
    }
}