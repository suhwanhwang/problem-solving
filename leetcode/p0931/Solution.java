class Solution {
    private int[][] dp;

    public int minFallingPathSum(int[][] matrix) {
        int min = Integer.MAX_VALUE;
        dp = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix[0].length; ++i) {
            min = Math.min(min, helper(matrix, 0, i));
        }
        return min;
    }

    private int helper(int[][] matrix, int row, int col) {
        if (row >= matrix.length) {
            return 0;
        }

        if (dp[row][col] != 0) {
            return dp[row][col];
        }

        int min = Integer.MAX_VALUE;
        if (col > 0) {
            min = Math.min(min, helper(matrix, row + 1, col - 1));
        }
        min = Math.min(min, helper(matrix, row + 1, col));
        if (col < matrix.length - 1) {
            min = Math.min(min, helper(matrix, row + 1, col + 1));
        }
        dp[row][col] = matrix[row][col] + min;
        return dp[row][col];
    }
}
