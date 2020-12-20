/*
https://leetcode.com/problems/word-search/description/

Given an m x n board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells, where "adjacent" cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.

Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
Output: true
*/
class Solution {
    
    int[][] dir = { {-1,0}, {0,1}, {1,0}, {0,-1} };
    boolean[][] visited;
    
    private boolean isExistPos(char[][] board, String word,int index, int r, int c) {
        if (index == word.length()) {
            return true;
        }
        
        if (r < 0 || r >= board.length || c < 0 || c >= board[r].length) {
            return false;
        }
        
        if (visited[r][c] || board[r][c] != word.charAt(index)) {
            return false;
        }
        
        visited[r][c] = true;
        for (int i = 0; i < dir.length; ++i) {
            int nr = r + dir[i][0];
            int nc = c + dir[i][1];
            
            if (isExistPos(board, word, index+1, nr, nc)) {
                return true;
            }
        }
        visited[r][c] = false;
        return false;
    }
    
    public boolean exist(char[][] board, String word) {
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[r].length; c++) {
                visited = new boolean[board.length][board[0].length];
                if (isExistPos(board, word, 0, r, c)) {
                    return true;
                }
                
            }
        }
        return false;
    }
}
