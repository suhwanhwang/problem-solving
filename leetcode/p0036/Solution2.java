class Solution {
    public boolean isValidSudoku(char[][] board) {
        List<Set<Integer>> rowSet = new ArrayList<>();
        List<Set<Integer>> colSet = new ArrayList<>();
        List<Set<Integer>> rectSet = new ArrayList<>();

        for (int i = 0; i < 9; ++i) {
            rowSet.add(new HashSet<>());
            colSet.add(new HashSet<>());
            rectSet.add(new HashSet<>());
        }

        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[i].length; ++j) {
                if (board[i][j] == '.') {
                    continue;
                }

                int num = board[i][j] - '0';

                if (rowSet.get(i).contains(num) 
                || colSet.get(j).contains(num) 
                || rectSet.get((i / 3) * 3 + j / 3).contains(num)) {
                    System.out.println(i + " " + j);
                    return false;
                }

                rowSet.get(i).add(num);
                colSet.get(j).add(num);
                rectSet.get((i / 3) * 3 + j / 3).add(num);
            }
        }
        
        return true;
    }
}
