/*
https://leetcode.com/problems/evaluate-reverse-polish-notation/

Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Note:

Division between two integers should truncate toward zero.
The given RPN expression is always valid. That means the expression would always evaluate to a result and there won't be any divide by zero operation.
Example 1:

Input: ["2", "1", "+", "3", "*"]
Output: 9
Explanation: ((2 + 1) * 3) = 9

*/
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        
        for(int i = 0; i < tokens.length; ++i) {
            String t = tokens[i];
            if (t.length() == 1) {
                char c = t.charAt(0);
                int a,b;
                switch(c) {
                case '+':
                    b = st.pop();
                    a = st.pop();
                    st.push(a + b);
                    break;
                case '-':
                    b = st.pop();
                    a = st.pop();
                    st.push(a - b);
                    break;
                case '*':
                    b = st.pop();
                    a = st.pop();
                    st.push(a * b);
                    break;
                case '/':
                    b = st.pop();
                    a = st.pop();
                    st.push(a / b);
                    break;
                default :
                st.push(Integer.parseInt(t));
                }
            } else {
                st.push(Integer.parseInt(t));
            }
            System.out.println("stack " + st.peek());
        }
        return st.pop();
        
    }
}
