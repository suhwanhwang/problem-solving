/*
https://leetcode.com/problems/generate-parentheses/

Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

 

Example 1:

Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]
Example 2:

Input: n = 1
Output: ["()"]
 

Constraints:

1 <= n <= 8
*/

class Solution {
    private List<String> ans;
    public List<String> generateParenthesis(int n) {
        ans = new ArrayList<>();
        helper(n, 0, 0, "");
        return ans;
    }
    private void helper(int n, int l, int r, String s) {
        if (l > n || r > n) return;
        
        if (l == n && r == n) {
            ans.add(s);
            return;
        }
        
        //left
        helper(n, l + 1, r, s + "(");
        
        //right
        if (l > r) {
            helper(n, l, r + 1, s + ")");
        }
    }
}
