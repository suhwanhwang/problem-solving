// https://leetcode.com/problems/rotting-oranges/
class Solution {
    private static final int[][] DIR = {
        {-1, 0}, {0, 1}, {1, 0}, {0, -1}
    };
    public int orangesRotting(int[][] grid) {
    
        int[][] cur = grid;
        int count = 0;
        
        while(!isAllRotten(cur)) {
            int[][] temp = new int[cur.length][cur[0].length];
            boolean isSame = true;
            for (int r = 0; r < cur.length; ++r) {
                for (int c = 0; c < cur[r].length; ++c) {
                    if (cur[r][c] == 1 && isRotten(cur, r, c)) {
                        temp[r][c] = 2;
                        isSame = false;
                    } else {
                        temp[r][c] = cur[r][c];
                    }
                }
            }
            if (isSame) {
                return -1;
            }
            cur = temp;
            count++;
        }
        return count;
    }
    private boolean isRotten(int[][] grid, int r, int c) {
        for (int k = 0; k < DIR.length; ++k) {
            int nr = r + DIR[k][0];
            int nc = c + DIR[k][1];
            if (nr < 0 || nr >= grid.length || nc < 0 || nc >= grid[r].length) {
                continue;
            }
            if (grid[nr][nc] == 2) {
                return true;
            }
        }
        return false;
    }
    
    private boolean isAllRotten(int[][] grid) {
        // for (int r = 0; r < grid.length; ++r) {
        //     for (int c = 0; c < grid[r].length; ++c) {
        //         System.out.print(grid[r][c] + " ");
        //     }
        //     System.out.println();
        // }
        // System.out.println();
        for (int r = 0; r < grid.length; ++r) {
            for (int c = 0; c < grid[r].length; ++c) {
                if (grid[r][c] == 1) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
}
