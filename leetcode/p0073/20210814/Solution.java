/*
https://leetcode.com/problems/set-matrix-zeroes/description/

*/
class Solution {
    public void setZeroes(int[][] matrix) {
        Set<Integer> zeroRow = new HashSet<>();
        Set<Integer> zeroCol = new HashSet<>();
        for(int i = 0; i < matrix.length; ++i) {
            for(int j = 0; j < matrix[i].length; ++j) {
                if (matrix[i][j] == 0) {
                    zeroRow.add(i);
                    zeroCol.add(j);
                }
            }
        }
        
        for(int i = 0; i < matrix.length; ++i) {
            for(int j = 0; j < matrix[i].length; ++j) {
                if (zeroRow.contains(i) || zeroCol.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
