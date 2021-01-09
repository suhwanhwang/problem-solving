/*
https://leetcode.com/problems/surrounded-regions/description/

Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

Example:

X X X X
X O O X
X X O X
X O X X
After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X
Explanation:

Surrounded regions shouldn’t be on the border, which means that any 'O' on the border of the board are not flipped to 'X'. Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'. Two cells are connected if they are adjacent cells connected horizontally or vertically.
*/
class Solution {
    boolean[][] visited;
    static final int[][] dir = {
        {-1,0},{0,1},{1,0},{0,-1}
    };
    private void dfs(char[][] board, int r, int c, List<int[]> region) {
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length) {
            return;
        }
        if (board[r][c] != 'O') {
            return;
        }
        if (visited[r][c]) {
            return;
        }
        
        visited[r][c] = true;
        region.add(new int[]{r,c});
        
        for (int i = 0; i < dir.length; ++i) {
            int nr = r+dir[i][0];
            int nc = c+dir[i][1];
            dfs(board, nr, nc, region);
        }
    }
    
private boolean isValid(List<int[]> region, int rLen, int cLen) {
        for (int[] v : region) {
            if (v[0] == 0 || v[0] == rLen - 1 || v[1] == 0 || v[1] == cLen - 1) {
                return false;
            }
        }
        return true;
    }
    
    private void flipRegion(char[][] board, List<int[]> region) {
        for (int[] v : region) {
            board[v[0]][v[1]] = 'X';
        }
    }
    
    public void solve(char[][] board) {
        if (board.length<=2 || board[0].length <= 2) {
            return;
        }
        visited = new boolean[board.length][board[0].length];
        List<List<int[]>> regions = new ArrayList<>();
        
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[i].length; ++j) {
                if (board[i][j] == 'O' && !visited[i][j]) {
                    List<int[]> r = new ArrayList<>();
                    
                    dfs(board, i, j, r);
                    regions.add(r);
                }
            }
        }
        for (List<int[]> r : regions) {
            if (isValid(r, board.length, board[0].length)) {
                flipRegion(board, r);
            }
        }
    }
}
