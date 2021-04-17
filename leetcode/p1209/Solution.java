/*
https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/

You are given a string s and an integer k, a k duplicate removal consists of choosing k adjacent and equal letters from s and removing them, causing the left and the right side of the deleted substring to concatenate together.

We repeatedly make k duplicate removals on s until we no longer can.

Return the final string after all such duplicate removals have been made. It is guaranteed that the answer is unique.

 

Example 1:

Input: s = "abcd", k = 2
Output: "abcd"
Explanation: There's nothing to delete.
Example 2:

Input: s = "deeedbbcccbdaa", k = 3
Output: "aa"
Explanation: 
First delete "eee" and "ccc", get "ddbbbdaa"
Then delete "bbb", get "dddaa"
Finally delete "ddd", get "aa"
Example 3:

Input: s = "pbbcggttciiippooaais", k = 2
Output: "ps"
 

Constraints:

1 <= s.length <= 10^5
2 <= k <= 10^4
s only contains lower case English letters.
*/
class Solution {
    static class Pair {
        int count;
        char c;
        
        public Pair(char c, int count) {
            this.c = c;
            this.count = count;
        }
    }
    public String removeDuplicates(String s, int k) {
        if (s.length() == 0) return s;
        
        Stack<Pair> st = new Stack<>();
        int index = 0;
        st.push(new Pair(s.charAt(index++),1));
        while(index < s.length()) {
            
            Pair top = st.isEmpty() ? new Pair(' ', 0) : st.peek();
            char c = s.charAt(index);
            if (top.c == c) {
                if (top.count + 1 == k) {
                    while(st.pop().count > 1);
                } else {
                    st.push(new Pair(c, top.count + 1));
                }
            } else {
                st.push(new Pair(c, 1));
            }
            index++;
        }
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.insert(0, st.pop().c);
        }
        return sb.toString();
    }
}
