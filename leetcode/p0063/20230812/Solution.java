class Solution {
    private int[][] dp;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        for (int[] item : dp) {
            Arrays.fill(item, -1);
        }
        
        return helper(obstacleGrid, 0, 0);
    }
    
    private int helper(int[][] grid, int row, int col) {
        if (row >= grid.length || col >= grid[0].length || grid[row][col] == 1) {
            return 0;
        }
        
        if (dp[row][col] != -1) {
            return dp[row][col];
        }
        
        if (row == grid.length - 1 && col == grid[0].length - 1) {
            return 1;
        }
        
        
        // right
        int rightPath = helper(grid, row, col + 1);
        // down
        int downPath = helper(grid, row + 1, col);
        
        dp[row][col] = rightPath + downPath;
        return dp[row][col];
    }
}
