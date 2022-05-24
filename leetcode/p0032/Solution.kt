class Solution {
    fun longestValidParentheses(s: String): Int {
        val st = Stack<Int>()
        var max = 0
        
        st.push(-1)
        for (i in s.indices) {
            when (s[i]) {
                '(' -> {
                    st.push(i)
                }
                ')' -> {
                    val top = st.peek()
                    if (top >= 0 && s[top] == '(') {
                        st.pop()
                        
                        max = Math.max(max, i - st.peek())
                    } else {
                        st.push(i)
                    }
                }
                else -> {}
            }    
        }
        return max
    }
}
