class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        int[] rowSum = new int[n];
        int[] colSum = new int[n];

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                rowSum[i] += grid[i][j];
                colSum[i] += grid[j][i];
            }
        }

        int count = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (rowSum[i] == colSum[j]) {
                    if (isSame(grid, i, j)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
    private boolean isSame(int[][] grid, int row, int col) {
        for (int i = 0; i < grid.length; ++i) {
            if (grid[row][i] != grid[i][col]) {
                return false;
            }
        }
        return true;
    }
}
