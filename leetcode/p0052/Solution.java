/*
The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

Given an integer n, return the number of distinct solutions to the n-queens puzzle.

 

Example 1:


Input: n = 4
Output: 2
Explanation: There are two distinct solutions to the 4-queens puzzle as shown.
Example 2:

Input: n = 1
Output: 1
 

Constraints:

1 <= n <= 9
*/

class Solution {
    private int total;
    private boolean[] col;
    private boolean[] diagonal;
    private boolean[] diagonalReverse;
    public int totalNQueens(int n) {
        total = 0;
        col = new boolean[n];
        diagonal = new boolean[2 * n];
        diagonalReverse = new boolean[2 * n];
        dfs(n, 0);
        return total;
    }
    
    private void dfs(int n, int r) {
        if (r == n) {
            total++;
            return;
        }
        
        for (int i = 0; i < n; ++i) {
            if (col[i] || diagonal[i - r  +  n] || diagonalReverse[i + r]) {
                continue;
            }
            
            col[i] = diagonal[i - r  +  n] = diagonalReverse[i + r] = true;
            dfs(n, r + 1);
            col[i] = diagonal[i - r  +  n] = diagonalReverse[i + r] = false;
        }
    }
}
