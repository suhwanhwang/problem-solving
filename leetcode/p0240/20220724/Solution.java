class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length - 1;
        int col = 0;
        while (row >= 0 && col < matrix[0].length) {
            int value = matrix[row][col];
            if (value == target) {
                return true;
            } else if (value > target) {
                row--;
            } else {
                col++;
            }
        }
        return false;
    }
}
