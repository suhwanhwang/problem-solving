/*
https://leetcode.com/problems/set-matrix-zeroes/

Given an m x n matrix. If an element is 0, set its entire row and column to 0. Do it in-place.

Follow up:

A straight forward solution using O(mn) space is probably a bad idea.
A simple improvement uses O(m + n) space, but still not the best solution.
Could you devise a constant space solution?
 

Example 1:


Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
Output: [[1,0,1],[0,0,0],[1,0,1]]
*/
class Solution {
    // O(m n) space
    public void setZeroes_(int[][] matrix) {
        List<Integer> zeroRow = new ArrayList<>();
        List<Integer> zeroCol = new ArrayList<>();
        for (int r = 0; r < matrix.length; ++r) {
            for (int c = 0; c < matrix[r].length; ++c) {
                if (matrix[r][c] == 0) {
                    zeroRow.add(r);
                    zeroCol.add(c);
                }
            }
        }
        
        for (Integer r : zeroRow) {
            Arrays.fill(matrix[r], 0);
        }
        
        for (Integer c : zeroCol) {
            for (int r = 0; r < matrix.length; ++r) {
                matrix[r][c] = 0;
            }
        }
    }
    
    // O(1) space
    public void setZeroes(int[][] matrix) {
        boolean isZeroFirstCol = false;
        for (int r = 0; r < matrix.length; ++r) {
            if (matrix[r][0] == 0) {
                isZeroFirstCol = true;
            }
            for (int c = 1; c < matrix[r].length; ++c) {
                if (matrix[r][c] == 0) {
                    // first row/col as a flag
                    matrix[r][0] = 0;
                    matrix[0][c] = 0;
                }
            }
        }
        
        for (int r = 1; r < matrix.length; ++r) {
            for (int c = 1; c < matrix[r].length; ++c) {
                if (matrix[r][0] == 0 || matrix[0][c] == 0) {
                    matrix[r][c] = 0;
                }
            }
        }
        
        if (matrix[0][0] == 0) {
            Arrays.fill(matrix[0], 0);
        }
        
        if (isZeroFirstCol) {
            for (int r = 0; r < matrix.length; ++r) {
                matrix[r][0] = 0;
            }
        }
    }
}
