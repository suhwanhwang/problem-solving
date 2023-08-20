class Solution {
    private int[][] dp;
    public int change(int amount, int[] coins) {
        dp = new int[amount + 1][coins.length];
        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }
        return helper(amount, coins, 0);
    }
    
    private int helper(int remain, int[] coins, int prevIndex) {
        if (remain == 0) {
            dp[remain][prevIndex] = 1;
            return 1;
        }
        
        if (dp[remain][prevIndex] != -1) {
            return dp[remain][prevIndex];
        }
        
        int sum = 0;
        for (int i = prevIndex; i < coins.length; ++i) {
            if (remain < coins[i]) {
                continue;
            }
            sum += helper(remain - coins[i], coins, i);
        }
        dp[remain][prevIndex] = sum;
        return sum;
    }
}
