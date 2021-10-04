// https://leetcode.com/problems/island-perimeter/description/
class Solution {
    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        
        for(int r = 0; r < grid.length; ++r) {
            for(int c = 0; c < grid[0].length; ++c) {
                perimeter += getPerimeter(grid, r, c);
            }
        }
        
        return perimeter;
    }
    
    private static final int[][] DIR = {
        {0,-1},{1,0},{0,1},{-1,0}
    };
    private int getPerimeter(int[][] grid, int r, int c) {
        if (grid[r][c] == 0) {
            return 0;
        }
        int perimeter = 0;
        for(int[] d : DIR) {
            int nr = r + d[0];
            int nc = c + d[1];
            if (nr < 0 || nr >= grid.length || nc < 0 || nc >= grid[0].length || grid[nr][nc] == 0) {
                perimeter++;
            }
        }
        return perimeter;
    }
}
