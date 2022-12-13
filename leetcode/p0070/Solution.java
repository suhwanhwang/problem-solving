class Solution {
    private int[] dp = new int[100];
    public int climbStairs(int n) {
        if (n == 0) return 1;
        else if (n < 0) return 0;

        if (dp[n] != 0) return dp[n];

        dp[n] = climbStairs(n - 1) + climbStairs(n - 2);
        return dp[n];
    }
}
