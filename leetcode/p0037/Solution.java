class Solution {
    private final Set[] rowSet = new HashSet[9];
    private Set[] colSet = new HashSet[9];
    private Set[] rectSet = new HashSet[9];
    public void solveSudoku(char[][] board) {
        for (int i = 0; i < 9; ++i) {
            rowSet[i] = new HashSet<Integer>();
            colSet[i] = new HashSet<Integer>();
            rectSet[i] = new HashSet<Integer>();
        }
        
        for(int i = 0; i < 9; ++i) {
            for(int j = 0; j < 9; ++j) {
                if (board[i][j] =='.') {
                    continue;
                }
                int num = board[i][j] - '0';
                rowSet[i].add(num);
                colSet[j].add(num);
                rectSet[3 * (i / 3) + (j / 3)].add(num);
            }
        }
        
        solve(board, 0, 0);
    }
    
    private boolean solve(char[][] board, int row, int col) {
        if (row == 9 && col == 0) {
            return true;
        }
        
        int nr = (col == 8 ? row + 1 : row);
        int nc = (col == 8 ? 0 : col + 1);
        
        if (board[row][col] != '.') {
            return solve(board, nr , nc);
        }
        
        for (int i = 1; i <= 9; ++i) {
            if (rowSet[row].contains(i) 
            || colSet[col].contains(i)
            || rectSet[3 * (row/3) + (col/3)].contains(i)) {
                continue;
            }
            board[row][col] = (char)('0' + i);
            rowSet[row].add(i);
            colSet[col].add(i);
            rectSet[3 * (row/3) + (col/3)].add(i);
                
            if (solve(board, nr , nc)) {
                return true;
            }
                
            rowSet[row].remove(i);
            colSet[col].remove(i);
            rectSet[3 * (row/3) + (col/3)].remove(i);
            board[row][col] = '.';
        }
        return false;
    }
}
