class Solution {
    private int[] dp = new int[10000 + 1];

    public int numSquares(int n) {
        if (n == 1) {
            return 1;
        }
        if (dp[n] != 0) {
            return dp[n];
        }
        int min = n;
        for (int i = 1; i * i <= n; ++i) {
            min = Math.min(min, 1 + numSquares(n - i * i));
        }
        dp[n] = min;
        return min;
    }
}
