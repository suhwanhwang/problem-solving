class Solution {
    private int[][] dp;
    public int uniquePaths(int m, int n) {
        dp = new int[m + 1][n + 1];
        return dfs(m,n,1,1);
    }
    private int dfs(int m, int n, int r, int c) {
        if(r > m || c > n) return 0;
        
        if(r == m && c == n) {
            return 1;
        }
        if (dp[r][c] != 0) {
            return dp[r][c];
        }
        dp[r][c] = dfs(m,n,r+1,c) +
        dfs(m,n,r,c+1);
        return dp[r][c];
    }
    
    public int uniquePaths_bu(int m, int n) {
        int[][] dp = new int[m][n];
        
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i == 0 && j == 0) {
                    dp[0][0] = 1;
                } else if (i == 0) {
                    dp[i][j] = dp[i][j-1];
                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i][j-1] + dp[i - 1][j];
                }
            }
        }
        return dp[m-1][n-1];
    }
}
