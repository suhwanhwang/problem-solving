class Solution {
    private int[] dp;
    public int minCostClimbingStairs(int[] cost) {
        dp = new int[cost.length];
        Arrays.fill(dp, -1);
        return Math.min(helper(cost, 0), helper(cost, 1));
    }
    
    private int helper(int[] cost, int index) {
        if (index >= cost.length) {
            return 0;
        }
        
        if (dp[index] != -1) {
            return dp[index];
        }
        
        int oneStep = cost[index] + helper(cost, index + 1);
        int twoStep = cost[index] + helper(cost, index + 2);
        dp[index] = Math.min(oneStep, twoStep);
        return dp[index];
    }
}
