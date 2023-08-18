class Solution {
    private static final int INF = 987654321;

    private static final int[][] DIR = {
        {0, 1},
        {1, 0},
        {0, -1},
        {-1, 0}
    };
    
    public int[][] updateMatrix(int[][] mat) {
        
        int[][] result = new int[mat.length][mat[0].length];
        Queue<int[]> queue = new ArrayDeque<>();
        
        for (int i = 0; i < mat.length; ++i) {
            for (int j = 0; j < mat[0].length; ++j) {
                result[i][j] = (mat[i][j] == 1 ? -1 : 0);
                if (result[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int row = cur[0];
            int col = cur[1];
            
            for (int[] d : DIR) {
                int nr = row + d[0];
                int nc = col + d[1];
                
                if (nr < 0 || nr >= mat.length || nc < 0 || nc >= mat[0].length || result[nr][nc] != -1) {
                    continue;
                }
                result[nr][nc] = result[row][col] + 1;
                queue.offer(new int[]{nr, nc});
            }
        }
        
        return result;
    }
}
