class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        
        for (int i = 0; i < c - 1; ++i) {
            for (int j = 1; j < r && i + j < c; ++j) {
                if (matrix[0][i] != matrix[j][i + j]) {
                    return false;
                }
            }
        }
        
        for (int i = 1; i < r - 1; ++i) {
            for (int j = 1; j < c && i + j < r; ++j) {
                if (matrix[i][0] != matrix[i + j][j]) {
                    return false;
                }
            }
        }
        
        return true;
    }
}
