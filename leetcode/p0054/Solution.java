/*
https://leetcode.com/problems/spiral-matrix/submissions/

Given an m x n matrix, return all elements of the matrix in spiral order.

Example 1:
Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]
*/
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        if (matrix.length ==0) {
            return ans;
        }
        
        int h = matrix.length;
        int w = matrix[0].length;
        int[][] dir = {
            {0, 1}, {1, 0}, {0, -1}, {-1, 0}   
        };
        boolean[][] added = new boolean[h][w];
        
        int r = 0;
        int c = 0;
        int d = 0;
        for (int i = 0; i < h * w; ++i) {
            ans.add(matrix[r][c]);
            added[r][c] = true;
            
            int nr = r + dir[d][0];
            int nc = c + dir[d][1];
            if (nr < 0 || nr >= h || nc < 0 || nc >= w || added[nr][nc]) {
                d = (d + 1) % dir.length;
            }
            r += dir[d][0];
            c += dir[d][1];
        }
        
        return ans;
    }
}
