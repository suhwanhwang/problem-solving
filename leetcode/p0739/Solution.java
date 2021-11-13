/*
Input: temperatures =

  0  1  2  3  4  5  6  7
[73,74,75,71,69,72,76,73]

[1,  1, 4, 2, 1, 1, 0, 0]

6 2 1


*/
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[temperatures.length];
        for (int i = temperatures.length - 1; i>=0; --i) {
            
            while(!st.isEmpty() && temperatures[st.peek()] <= temperatures[i]) {
                st.pop();
            }
            ans[i] = (st.isEmpty() ? 0 : st.peek() - i);
            st.push(i);
        }
        return ans;
    }
}
