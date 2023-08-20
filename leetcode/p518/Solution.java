class Solution {
    private int[][] dp;
    public int change(int amount, int[] coins) {
        dp = new int[amount + 1][coins.length];
        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }
        return helper(amount, coins, 0);
    }
    
    private int helper(int remain, int[] coins, int index) {
        if (index >= coins.length) {
            return 0;
        }
        
        if (remain == 0) {
            return 1;
        }
        
        if (dp[remain][index] != -1) {
            return dp[remain][index];
        }
        
        int sum = 0;
        if (coins[index] <= remain) {
            sum = helper(remain - coins[index], coins, index);
        }
        sum += helper(remain, coins, index + 1);
        dp[remain][index] = sum;
        return sum;
    }
}
