class Solution {
    fun isValid(s: String): Boolean {
        val stack = Stack<Char>()
        
        for(c in s) {
            when (c) {
                '(', '{', '[' -> { 
                    stack.push(c)
                }
                ')', '}', ']' -> {
                    if (stack.isEmpty()) {
                        return false
                    }
                    val top = stack.pop()
                    if (!(top == '(' && c == ')' || top == '{' && c == '}' || top == '[' && c == ']')) {
                        return false
                    }
                }
            }
        }
        return stack.isEmpty()
    }
}
