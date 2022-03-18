class Solution {
    public int scoreOfParentheses(String s) {
        if (s.length() == 0) {
            return 0;
        }
        if (s.equals("()")) {
            return 1;
        }
        
        int pairedIndex = getPairedIndex(s, 0);
        String sub = s.substring(1, pairedIndex);
        
        return (sub.length() > 0 ? 2 * scoreOfParentheses(sub) : 1)+ scoreOfParentheses(s.substring(pairedIndex + 1));
    }
    
    private int getPairedIndex(String s, int start) {
        Stack<Integer> st = new Stack<>();
        st.push(start);
        for (int i = start + 1; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (c == '(') {
                st.push(i);
            } else if (c == ')') {
                int top = st.pop();
                if (st.isEmpty()) {
                    return i;
                }
            }
        }
        return -1;
    }
}
