class Solution {
    fun validateStackSequences(pushed: IntArray, popped: IntArray): Boolean {
        val len = pushed.size
        var i = 0
        var j = 0
        val st = Stack<Int>()
        st.push(pushed[i++])
        while (!st.isEmpty()) {
            val top = st.peek()
            println("${top} ${i} ${j}")
            if (top == popped[j]) {
                st.pop()
                j++
                if (st.isEmpty() && i < len) {
                    st.push(pushed[i++])
                }
            } else if (i < len) {
                st.push(pushed[i++])
            } else {
                return false
            }
        }
        return true
    }
}
