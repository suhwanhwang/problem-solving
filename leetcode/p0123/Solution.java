class Solution {
    private int[][][] dp;
    public int maxProfit(int[] prices) {
        dp = new int[2][prices.length][2];
        for(int i = 0; i < 2; ++i) {
            for(int j = 0; j < prices.length; ++j) {
                for(int k = 0; k < 2; ++k) dp[i][j][k] = -1;
            }
        }
        return helper(prices, 0, 0, 0);
    }
    
    private int helper(int[] prices, int buy, int index, int transaction) {
        if (index >= prices.length) {
            return 0;
        }
        
        if (transaction >= 2) {
            return 0;
        }
        
        if (dp[buy][index][transaction] != -1) {
            return dp[buy][index][transaction];
        }
        int max = 0;
        if (buy == 0) {
            //buy or not
            max = Math.max(- prices[index] + helper(prices, 1, index+1, transaction),
            helper(prices, 0, index+1, transaction));
        } else {
            // sell or not
            max = Math.max(prices[index] + helper(prices, 0, index+1, transaction+1),
            helper(prices, buy, index+1, transaction));
        }
        return dp[buy][index][transaction] = max;
    }
}
