/*
https://leetcode.com/problems/max-area-of-island/

You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

The area of an island is the number of cells with a value 1 in the island.

Return the maximum area of an island in grid. If there is no island, return 0.

 

Example 1:


Input: grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
Output: 6
Explanation: The answer is not 11, because the island must be connected 4-directionally.
Example 2:

Input: grid = [[0,0,0,0,0,0,0,0]]
Output: 0
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 50
grid[i][j] is either 0 or 1.
*/
class Solution {
    private boolean[][] visited;
    
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        visited = new boolean[grid.length][grid[0].length];
        
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[i].length; ++j) {
                maxArea = Math.max(maxArea, dfs(grid, i, j));
            }
        }
        
        return maxArea;
    }
    
    private static final int[][] DIR = {
        {-1, 0},
        {0, 1},
        {1, 0},
        {0, -1}
    };
    
    private int dfs(int[][] grid, int row, int col) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[row].length) {
            return 0;
        }

        if (grid[row][col] == 0 || visited[row][col]) {
            return 0;
        }
        
        int curArea = 1;
        visited[row][col] = true;
        
        for (int[] dir : DIR) {
            int nextRow = row + dir[0];
            int nextCol = col + dir[1];
            curArea += dfs(grid, nextRow, nextCol);
        }
        return curArea;
    }
}
