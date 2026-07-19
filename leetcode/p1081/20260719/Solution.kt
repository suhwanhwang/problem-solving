class Solution {
    fun smallestSubsequence(s: String): String {
        val stack = LinkedHashSet<Char>()
        val lastIndex = mutableMapOf<Char, Int>()

        for ((i, c) in s.withIndex()) {
            lastIndex[c] = i
        }

        for ((i, c) in s.withIndex()) {
            if (stack.contains(c)) {
                continue
            }

            while (stack.isNotEmpty() && stack.last() > c && lastIndex[stack.last()]!! > i) {
                stack.remove(stack.last())
            }
            stack.add(c)
        }

        return stack.joinToString("")
    }
}
