/*
https://leetcode.com/problems/decode-ways/description/

A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given a non-empty string containing only digits, determine the total number of ways to decode it.

The answer is guaranteed to fit in a 32-bit integer.

 

Example 1:

Input: s = "12"
Output: 2
Explanation: It could be decoded as "AB" (1 2) or "L" (12).
*/
class Solution {
    int[] dp;
    int solve(String s, int index) {
        if(index == s.length()) {
            return 1;
        }
        
        if(index > s.length()) {
            return 0;
        }
        
        if (dp[index] > -1) {
            return dp[index];
        }
        
        char c = s.charAt(index);
        int ans;
        if (c > '2'
        || (c == '2' && (index + 1 == s.length() || s.charAt(index + 1) > '6'))) {
            ans = solve(s, index + 1);
        } else if (c == '2' || c == '1') {
            ans = solve(s, index + 1) + solve(s, index + 2);
        } else {
            ans = 0;
        }
        dp[index] = ans;
        return ans;
    }
    public int numDecodings(String s) {
        dp = new int[s.length()];
        Arrays.fill(dp, -1);
        return solve(s, 0);
    }
}
