// https://leetcode.com/problems/surrounded-regions/
class Solution {
    boolean[][] visited;
    
    public void solve(char[][] board) {
        visited = new boolean[board.length][board[0].length];
        
        for(int i = 0; i < board.length; ++i) {
            for(int j = 0; j < board[i].length; ++j) {
                if (visited[i][j] || board[i][j] == 'X') {
                    continue;
                }
                List<int[]> path = new ArrayList<>();
                dfs(board,i,j,path);
                if (isValid(path, board.length, board[0].length)) {
                    for(int[] p : path) {
                        board[p[0]][p[1]] = 'X';
                    }
                }
            }
        }
    }
    private boolean isValid(List<int[]> path, int row, int col) {
        for(int[] p : path) {
            if (p[0] == 0 || p[0] == row - 1 || p[1] == 0 || p[1] == col - 1) {
                return false;
            }
        }
        return true;
    }
    
    private static final int[][] DIR = {
        {-1,0},{0,1},{1,0},{0,-1}
    };
    private void dfs(char[][] b, int r, int c, List<int[]> path) {
        visited[r][c] = true;
        path.add(new int[]{r,c});
        for (int[]d : DIR) {
            int nr = r+d[0];
            int nc = c+d[1];
            if(nr<0||nr>=b.length||nc<0||nc>=b[0].length) {
                continue;
            }
            if (visited[nr][nc] || b[nr][nc] == 'X') {
                continue;
            }
            dfs(b,nr,nc,path);
        }
    }
}
