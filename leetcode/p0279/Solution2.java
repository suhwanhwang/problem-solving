class Solution {
    private static final int INF = 987654321;
    private int[] dp = new int[10000+1];
    public int numSquares(int n) {
        if (n < 0) {
            return INF;
        }
        if (n == 0) {
            return 0;
        }
        if (dp[n] != 0) {
            return dp[n];
        }
        int min = INF;
        for(int i = 1; i*i <= n; ++i) {
            min = Math.min(min, numSquares(n - i*i));
        }
        dp[n] = 1 + min;
        return dp[n];
    }
}
