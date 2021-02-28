/*
https://leetcode.com/problems/coin-change/

You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.

 

Example 1:

Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1
Example 2:

Input: coins = [2], amount = 3
Output: -1
Example 3:

Input: coins = [1], amount = 0
Output: 0
Example 4:

Input: coins = [1], amount = 1
Output: 1
Example 5:

Input: coins = [1], amount = 2
Output: 2
 

Constraints:

1 <= coins.length <= 12
1 <= coins[i] <= 231 - 1
0 <= amount <= 104
*/
class Solution {
    /*
    f(n) = min (f(n - x0) + 1, ... ,f(n - xn) + 1)
    */
    private static final int INF = 987654321;
    private int[] dp;
    public int coinChange(int[] coins, int amount) {
        dp = new int[amount + 1];
        int minVal = solve(coins, amount);
        return minVal == INF ? -1 : minVal;
    }
    
    public int solve(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (dp[amount] > 0) {
            return dp[amount];
        }
        
        int minVal = INF;
        for (int c : coins) {
            if (amount - c < 0) {
                continue;
            }

            minVal = Math.min(minVal, 1 + solve(coins, amount - c));
        }
        dp[amount] = minVal;
        return minVal;
    }
}
