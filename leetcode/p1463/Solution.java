class Solution {
    private int[][][] dp;
    public int cherryPickup(int[][] grid) {
        dp = new int[grid.length][grid[0].length][grid[0].length];
        for (int i = 0; i < dp.length; ++i) {
            for (int j = 0; j < dp[i].length; ++j) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        return helper(grid, 0, 0, grid[0].length - 1);
    }
    
    private static final int[][] DIR = {
        {-1, -1},{-1, 0},{-1, 1},
        {0, -1},{0, 0},{0, 1},
        {1, -1},{1, 0},{1, 1}
    };
    
    private int helper(int[][] grid, int r, int c0, int c1) {
        if (r >= grid.length) {
            return 0;
        }
        if (dp[r][c0][c1] != -1) {
            return dp[r][c0][c1];
        }
        int cur = (c0 == c1 ? grid[r][c0] : grid[r][c0] + grid[r][c1]);
        
        int max = 0;
        for (int[]d : DIR) {
            int nc0 = c0 + d[0];
            int nc1 = c1 + d[1];
            if (nc0 < 0 || nc0 >= grid[r].length || nc1 < 0 || nc1 >= grid[r].length) {
                continue;
            }
            max = Math.max(max, helper(grid, r + 1, nc0, nc1));
        }
        dp[r][c0][c1] = cur + max;
        return dp[r][c0][c1];
    }
}
