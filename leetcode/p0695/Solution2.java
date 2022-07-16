class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        boolean[][] isVisited = new boolean[grid.length][grid[0].length];
        
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[i].length; ++j) {
                maxArea = Math.max(maxArea, dfs(grid, i, j, isVisited));
            }
        }
        return maxArea;
    }
    
    private static final int[][] DIR = {
        {-1, 0}, {0, 1}, {1, 0}, {0, -1}    
    };
    private int dfs(int[][] grid, int row, int col, boolean[][] isVisited) {
        if (row < 0 || row >= grid.length 
            || col < 0 || col >= grid[row].length
            || isVisited[row][col] 
            || grid[row][col] == 0) {
            return 0;
        }
        
        int area = 1;
        isVisited[row][col] = true;
        for (int[] d : DIR) {
            int nextRow = row + d[0];
            int nextCol = col + d[1];
            area += dfs(grid, nextRow, nextCol, isVisited);
        }
        return area;
    }
}
