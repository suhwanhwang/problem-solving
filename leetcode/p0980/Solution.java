class Solution {
    private int allPath = 0;

    public int uniquePathsIII(int[][] grid) {
        int count = 0;
        int[] start = new int[2];
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[i].length; ++j) {
                if (grid[i][j] != -1) {
                    count++;
                }
                
                if (grid[i][j] == 1) {
                    start[0] = i;
                    start[1] = j;
                }
            }
        }
        
        visited = new boolean[grid.length][grid[0].length];
        dfs(grid, start[0], start[1], count);
        return allPath;
    }

    private static final int[][] DIR = {
        {-1, 0}, {0, 1}, {1, 0}, {0, -1}
    };

    private boolean[][] visited;
    private void dfs(int[][] grid, int row, int col, int remain) {
        if (grid[row][col] == 2) {
            if (remain == 1) {
                allPath++;
            }
            return;
        }

        visited[row][col] = true;
        //System.out.println(row + "," + col + " " + remain);

        for (int[] d : DIR) {
            int nr = row + d[0];
            int nc = col + d[1];
            if (nr < 0 || nr >= grid.length || nc < 0 || nc >= grid[0].length) continue;
            if (visited[nr][nc]) continue;

            if (grid[nr][nc] != -1) {
                dfs(grid, nr, nc, remain - 1);
            }
        }

        visited[row][col] = false;
    }
}
