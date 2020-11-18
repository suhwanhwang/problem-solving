/*
https://leetcode.com/problems/valid-sudoku/

Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
*/

class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] hor = new boolean[10][10];
        boolean[][] ver = new boolean[10][10];
        boolean[][] cell = new boolean[10][10];
        
        for(int r = 0; r < board.length; r++) {
            for(int c = 0; c < board[r].length; c++) {
                if (board[r][c] == '.') {
                    continue;
                }
                int num = board[r][c] - '0';
                int cellIndex = 3 * (r/3) + c/3;
                if (hor[r][num] || ver[c][num] || cell[cellIndex][num]) {
                    return false;
                }
                hor[r][num] = ver[c][num] = cell[cellIndex][num] = true;
            }
        }
        return true;
    }
}
