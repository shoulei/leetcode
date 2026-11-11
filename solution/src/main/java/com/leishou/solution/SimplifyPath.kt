package com.leishou.solution

/*
    You are given an absolute path for a Unix-style file system, which always begins with a slash
    '/'. Your task is to transform this absolute path into its simplified canonical path.
    The rules of a Unix-style file system are as follows:
    1, A single period '.' represents the current directory.
    2, A double period '..' represents the previous/parent directory.
    3, Multiple consecutive slashes such as '//' and '///' are treated as a single slash '/'.
    4, Any sequence of periods that does not match the rules above should be treated as a valid
    directory or file name. For example, '...' and '....' are valid directory or file names.

    The simplified canonical path should follow these rules:
    1, The path must start with a single slash '/'.
    2, Directories within the path must be separated by exactly one slash '/'.
    3, The path must not end with a slash '/', unless it is the root directory.
    4, The path must not have any single or double periods ('.' and '..') used to denote current or
    parent directories.

    Return the simplified canonical path.

    1 <= path.length <= 3000
    path consists of English letters, digits, period '.', slash '/' or '_'.
    path is a valid absolute Unix path.
 */
class SimplifyPath {
    fun simplifyPath(path: String): String {
        val queue = Array(path.length) { "" }
        var top = -1
        val sb = StringBuilder()

        fun handleString() {
            when (val str = sb.toString()) {
                "", "." -> {
                    // do nothing
                }

                ".." -> {
                    if (top >= 0) {
                        top--
                    }
                }

                else -> {
                    queue[++top] = str
                }
            }
        }

        for (c in path) {
            if (c == '/') {
                handleString()
                sb.clear()
            } else {
                sb.append(c)
            }
        }

        if (sb.isNotEmpty()) {
            handleString()
        }

        sb.clear()
        sb.append("/")
        for (i in 0..top) {
            sb.append(queue[i])
            sb.append("/")
        }

        val length = sb.length
        return if (length == 1) sb.toString() else sb.substring(0, length - 1)
    }
}