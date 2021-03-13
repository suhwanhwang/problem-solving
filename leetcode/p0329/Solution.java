/*
https://leetcode.com/problems/longest-increasing-path-in-a-matrix/

Given an m x n integers matrix, return the length of the longest increasing path in matrix.

From each cell, you can either move in four directions: left, right, up, or down. You may not move diagonally or move outside the boundary (i.e., wrap-around is not allowed).

 

Example 1:


Input: matrix = [[9,9,4],[6,6,8],[2,1,1]]
Output: 4
Explanation: The longest increasing path is [1, 2, 6, 9].
Example 2:


Input: matrix = [[3,4,5],[3,2,6],[2,2,1]]
Output: 4
Explanation: The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.
Example 3:

Input: matrix = [[1]]
Output: 1
 

Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 200
0 <= matrix[i][j] <= 231 - 1
*/
class Solution {
    int[][] dp;
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        dp = new int[matrix.length][matrix[0].length];
        int max = 0;
        for(int r = 0; r < matrix.length; ++r) {
            for(int c = 0; c < matrix[r].length; ++c) {
                max = Math.max(max, helper(matrix,r,c));
            }
        }
        return max;
    }
    
    static final int[][] DIR = {
        {-1, 0},{0, 1},{1,0},{0,-1}
    };
    private int helper(int[][] m, int r, int c) {
        if (r < 0 || r >= m.length || c < 0 || c >= m[0].length) {
            return 0;
        }
        
        if (dp[r][c] != 0) {
            return dp[r][c];
        }
        
        int max = 1;
        
        for (int[]d : DIR) {
            int nr = r + d[0];
            int nc = c + d[1];
            if (nr < 0 || nr >= m.length || nc < 0 || nc >= m[0].length) {
                continue;
            }
            if (m[nr][nc] <= m[r][c]) {
                continue;
            }
            max = Math.max(max, 1+helper(m,nr,nc));
        }
        dp[r][c] = max;
        return max;
    }
}
