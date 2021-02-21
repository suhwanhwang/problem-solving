/*
https://leetcode.com/problems/perfect-squares/

Given an integer n, return the least number of perfect square numbers that sum to n.

A perfect square is an integer that is the square of an integer; in other words, it is the product of some integer with itself. For example, 1, 4, 9, and 16 are perfect squares while 3 and 11 are not.

 

Example 1:

Input: n = 12
Output: 3
Explanation: 12 = 4 + 4 + 4.
Example 2:

Input: n = 13
Output: 2
Explanation: 13 = 4 + 9.
 

Constraints:

1 <= n <= 104

f(n) = f(1) + f(n - 1)
*/

class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        return helper(n, dp);
    }
    
    public int helper(int n, int[] dp) {
        if (n <= 0) {
            return 0;
        }
        
        if (dp[n] > 0) {
            return dp[n];
        }
        
        int min = Integer.MAX_VALUE;
        for (int i = 1; i * i <= n; ++i) {
            min = Math.min(min, 1 + helper(n - i*i, dp));
        }
        
        dp[n] = min;
        return min;
    }
}
