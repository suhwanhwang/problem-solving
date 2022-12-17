class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();

        for(String token : tokens) {
            if ("+".equals(token)) {
                int b = st.pop();
                int a = st.pop();
                st.push(a + b);
            } else if ("-".equals(token)) {
                int b = st.pop();
                int a = st.pop();
                st.push(a - b);
            } else if ("*".equals(token)) {
                int b = st.pop();
                int a = st.pop();
                st.push(a * b);
            } else if ("/".equals(token)) {
                int b = st.pop();
                int a = st.pop();
                st.push(a / b);
            } else {
                st.push(Integer.parseInt(token));
            }
        }
        return st.pop();
    }
}
