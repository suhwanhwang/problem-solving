/*
https://leetcode.com/problems/rotate-image/
You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).

You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.

 

Example 1:


Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [[7,4,1],[8,5,2],[9,6,3]]
*/
class Solution {
    /*
    [
      [1,2,3],
      [4,5,6],
      [7,8,9]
    ]
    */
    
    public void rotate(int[][] matrix) {
        for (int i = 0; i < matrix.length / 2; ++i) {
            int r = i;
            int c = i;
            int len = matrix[i].length - 2*i;
            for (int j = 0; j < len - 1; ++j) {
                int tmp = matrix[r][c + j];
                
                matrix[r][c + j] = matrix[r + len - 1 - j][c];
                matrix[r + len - 1 - j][c] = matrix[r + len - 1][c + len - 1 - j];
                matrix[r + len - 1][c + len - 1 - j] = matrix[r + j][c + len - 1];
                matrix[r + j][c + len - 1] = tmp;
            }
            
        }
    }
}
