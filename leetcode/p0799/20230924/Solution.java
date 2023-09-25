class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] dp = new double[101][101];
        dp[0][0]= poured;
        for (int i = 1; i <= query_row; ++i) {
            
            for (int j = 0; j <= i; ++j) {
                if (j > 0)
                    dp[i][j] += Math.max(0.0, (dp[i - 1][j - 1] - 1) / 2.0);
                if (j < i)
                    dp[i][j] += Math.max(0.0, (dp[i - 1][j] - 1) / 2.0);
            }
        }
        
        return dp[query_row][query_glass] > 1.0 ? 1.0 : dp[query_row][query_glass];
    }
}
