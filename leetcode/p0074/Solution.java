class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0;
        
        for (int i = 0; i < matrix.length; ++i) {
            if (matrix[i][0] > target) {
                break;
            } 
            row = i;
        }
        
        for (int i = 0; i < matrix[row].length; ++i) {
            if (matrix[row][i] == target) {
                return true;
            } else if (matrix[row][i] > target) {
                return false;
            }
        }
        return false;
    }
}
