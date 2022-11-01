class Solution {
    public int[] findBall(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        
        int[] ans = new int[grid[0].length];
        
        for(int i = 0; i < col; ++i) {
            ans[i] = getEnd(grid, i);
        }
        
        return ans;
    }
    private int getEnd(int[][] grid, int start) {
        int row = grid.length;
        int col = grid[0].length;
        
        int cur = start;
        for(int i = 0; i < row; ++i) {
            int num = grid[i][cur];
            
            int neighborCol = (num > 0 ? cur + 1 : cur - 1);
            if (neighborCol < 0 || neighborCol >= col) {
                return -1;
            }
            int neighborNum = grid[i][neighborCol];
            
            if (num * neighborNum < 0) {
                return -1;
            }
            
            cur += num;
        }
        return cur;
    }
}
