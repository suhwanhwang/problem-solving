class Solution {
    private static final int INF = 987654321;
    private static final int[][] DIR = {
        {0, 1}, {1, 0}, {0, -1}, {-1, 0}
    };
    public int maxDistance(int[][] grid) {
        final int[][] distance = new int[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[i].length; ++j) {
                if (grid[i][j] == 1) {
                    distance[i][j] = 0;
                } else {
                    distance[i][j] = INF;
                }
            }
        }

        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[i].length; ++j) {
                if (grid[i][j] == 1) {
                    dfs(distance, i, j, 0);
                }
            }
        }
        int max = 0;
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[i].length; ++j) {
                max = Math.max(max, distance[i][j]);
            }
        }
        return (max == INF || max == 0 ? -1 : max);
    }

    private void dfs(int[][] distance, int row, int col, int depth) {
        if (depth != 0) {
            distance[row][col] = depth;
        }

        for (int[] d : DIR) {
            int nr = row + d[0];
            int nc = col + d[1];
            if (nr < 0 || nr >= distance.length || nc < 0 || nc >= distance[row].length
            || distance[nr][nc] <= depth + 1 || distance[nr][nc] == 0) {
                continue;
            }
            dfs(distance, nr, nc, depth + 1);    
        }
    }
}
