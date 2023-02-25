class Solution {
    private int[][] dp;
    public int uniquePaths(int m, int n) {
        dp = new int[m+1][n+1];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        return dfs(m,n,1,1);
    }
    
    private int dfs(int m, int n, int r, int c) {
        if(r == m && c == n) return 1;
        else if (r > m || c > n) return 0;
        if (dp[r][c] != -1) return dp[r][c];
        
        dp[r][c] = dfs(m,n,r+1,c) + dfs(m,n,r,c+1);
        return dp[r][c];
    }
}
