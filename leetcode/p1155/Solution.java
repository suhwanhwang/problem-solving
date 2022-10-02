class Solution {
    private int[][] dp;
    public int numRollsToTarget(int n, int k, int target) {
        dp = new int[n + 1][target + 1];
        for (int i = 0; i <= n; ++i)
            Arrays.fill(dp[i], -1);
        
        return dfs(n,k,target);
    }
    
    public int dfs(int n, int k, int target) {
        if (n <= 0) {
            return target == 0 ? 1 : 0;
        }
        
        if(dp[n][target] != -1)
            return dp[n][target];
        
        long sum = 0;
        for (int i = 1; i <= k; ++i) {
            if (target - i >= 0) {
                sum += dfs(n - 1, k, target - i);
                sum %= (int)1e9+7;
            }
        }
        
        dp[n][target] = (int)sum;
        return dp[n][target];
    }
}
