/*
https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/

Say you have an array prices for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).

Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).

Example 1:

Input: [7,1,5,3,6,4]
Output: 7
Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
             Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
*/

class Solution {
    private int solve(int[] prices, int index, int[] dp) {
        if (index >= prices.length) {
            return 0;
        }
        
        if (dp[index] != -1) {
            return dp[index];
        }
        
        int max = 0;

        for (int i = index; i < prices.length; ++i) {
            for (int j = i + 1; j < prices.length; ++j) {
                int p = prices[j] - prices[i];
                if (p <= 0) {
                    continue;
                }
                
                max = Math.max(max, p + solve(prices, j+1, dp));
            }
        }
        dp[index] = max;
        return max;
    }
    
    public int maxProfit(int[] prices) {
        int[] dp = new int[prices.length];
        Arrays.fill(dp, -1);
        return solve(prices, 0, dp);
    }
}
