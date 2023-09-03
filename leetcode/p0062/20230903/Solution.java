class Solution {
    private int[][]dp;
    public int uniquePaths(int m, int n) {
        dp = new int[m + 1][n + 1];
        for(int[] d : dp) {
            Arrays.fill(d, -1);
        }
        return helper(m, n, 1, 1);
    }
    
    private int helper(int m, int n, int row, int col) {
        if (row > m || col > n) {
            return 0;
        }
        if (row == m && col == n) {
            return 1;
        }
        if (dp[row][col] != -1) {
            return dp[row][col];
        }
        dp[row][col] = helper(m, n, row + 1, col) + helper(m, n, row, col + 1);
        return dp[row][col];
    }
}
