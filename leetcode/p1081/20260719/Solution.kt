class Solution {
    fun smallestSubsequence(s: String): String {
        val stack = ArrayDeque<Char>()
        val added = BooleanArray(26)
        val lastIndex = mutableMapOf<Char, Int>()

        for ((i, c) in s.withIndex()) {
            lastIndex[c] = i
        }

        for ((i, c) in s.withIndex()) {
            if (added[c - 'a']) {
                continue
            }

            while (stack.isNotEmpty() && stack.last() > c && lastIndex[stack.last()]!! > i) {
                added[stack.last() - 'a'] = false
                stack.removeLast()
            }
            added[c - 'a'] = true
            stack.addLast(c)
        }

        return stack.joinToString("")
    }
}
