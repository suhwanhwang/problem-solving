class Solution {
    fun makeGood(s: String): String {
        val stack = ArrayDeque<Char>()
        
        for (c in s) {
            if (!stack.isEmpty() && isBad(stack.last(), c)) {
                stack.removeLast()
            } else {
                stack.addLast(c)
            }
        }
        
        val sb = StringBuilder()
        while (!stack.isEmpty()) {
            sb.insert(0, stack.removeLast())
        }
        return sb.toString()
    }
    
    private fun isBad(a: Char, b: Char): Boolean {
        return a.isUpperCase() != b.isUpperCase() && a.uppercase() == b.uppercase()
    }
}
