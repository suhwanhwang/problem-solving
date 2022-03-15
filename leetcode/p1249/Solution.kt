class Solution {
    fun minRemoveToMakeValid(s: String): String {
        val v1 = getValid(s)
        //println(v1)
        val v2 = getValid(v1.reversed(), true)
        //println(v2)
        return v2.reversed()
    }
    
    private fun getValid(s: String, isReversed: Boolean = false): String {
        val tokens = parse(s)
        val valid = StringBuilder()
        val st = Stack<String>()
        val OPEN = if (isReversed) ")" else "("
        val CLOSE = if (isReversed) "(" else ")"
        for (t in tokens) {
            if (t == OPEN) {
                st.push(t)
                valid.append(t)
            } else if (t == CLOSE) {
                if (st.isEmpty()) {
                    // skip
                } else {
                    st.pop()
                    valid.append(t)
                }
            } else {
                valid.append(t)
            }
        }
        return valid.toString()
    }
    
    private fun parse(s: String): List<String> {
        val tokens = mutableListOf<String>()
        val sb = StringBuilder()
        for (c in s) {
            if (c == '(' || c == ')') {
                if (sb.length > 0) {
                   tokens.add(sb.toString())
                    sb.clear()
                }
                tokens.add(c.toString())
            } else {
                sb.append(c)
            }
        }
        if (sb.length > 0) {
            tokens.add(sb.toString())
        }
        return tokens
    }
}
