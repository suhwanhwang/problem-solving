/*
https://leetcode.com/problems/01-matrix/

*/
class Solution {
    private static final int[][] DIR = {
        {0, 1}, {1, 0}, {0, -1}, {-1, 0}
    };
    public int[][] updateMatrix(int[][] mat) {
        Queue<int[]> queue = new ArrayDeque<>();
        
        for (int i = 0; i < mat.length; ++i) {
            for (int j = 0; j < mat[i].length; ++j) {
                if (mat[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                } else {
                    mat[i][j] = -1;
                }
            }
        }
        
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int r = cur[0];
            int c = cur[1];
            
            for (int i = 0; i < DIR.length; ++i) {
                int nr = r + DIR[i][0];
                int nc = c + DIR[i][1];
                if (nr < 0 || nr >= mat.length || nc < 0 || nc >= mat[0].length || mat[nr][nc] != -1) {
                    continue;
                }
                mat[nr][nc] = mat[r][c] + 1;
                queue.add(new int[]{nr, nc});
            }
        }
        return mat;
    }
}
