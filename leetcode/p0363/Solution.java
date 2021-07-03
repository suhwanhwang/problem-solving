/*
https://leetcode.com/problems/max-sum-of-rectangle-no-larger-than-k/

Given an m x n matrix matrix and an integer k, return the max sum of a rectangle in the matrix such that its sum is no larger than k.

It is guaranteed that there will be a rectangle with a sum no larger than k.

 

Example 1:


Input: matrix = [[1,0,1],[0,-2,3]], k = 2
Output: 2
Explanation: Because the sum of the blue rectangle [[0, 1], [-2, 3]] is 2, and 2 is the max number no larger than k (k = 2).
Example 2:

Input: matrix = [[2,2,-1]], k = 3
Output: 3
 

Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 100
-100 <= matrix[i][j] <= 100
-10^5 <= k <= 10^5
*/
class Solution {
    /* time limit
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int[][] cumulative = new int[matrix.length][matrix[0].length];
        
        for (int i = 0; i < matrix.length; ++i) {
            cumulative[i][0] = matrix[i][0];
            for (int j = 1; j < matrix[i].length; ++j) {
                cumulative[i][j] = cumulative[i][j - 1] + matrix[i][j];
                
                // if (i > 0) {
                //     cumulative[i][j] += cumulative[i - 1][j];
                // }
            }
        }
        
        int maxSum = Integer.MIN_VALUE;
        
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = i; j < matrix.length; ++j) {
                for (int m = 0; m < matrix[j].length; ++m) {
                    for (int n = m; n < matrix[j].length; ++n) {
                        int sum = 0;
                        for (int o = i; o <= j; ++o) {
                            sum += (cumulative[o][n] - (m > 0 ? cumulative[o][m - 1] : 0));
                        }
                        //System.out.println(m + ", " + n + " = " + sum);
                        if (sum > k) continue;
                        
                        maxSum = Math.max(maxSum, sum);
                    }
                }
            }
        }
        return maxSum;   
    }
    */
    
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int[][] cumulative = new int[matrix.length][matrix[0].length];
        
        for (int i = 0; i < matrix.length; ++i) {
            cumulative[i][0] = matrix[i][0];
            if (i > 0) {
                cumulative[i][0] += cumulative[i - 1][0];
            }
            int sum = matrix[i][0];
            for (int j = 1; j < matrix[i].length; ++j) {
                sum += matrix[i][j];
                cumulative[i][j] = sum;
                if (i > 0) {
                    cumulative[i][j] += cumulative[i - 1][j];
                }
            }
        }
        /*
        for (int i = 0; i < cumulative.length; ++i) {
            for (int j = 0; j < cumulative[i].length; ++j) {
                System.out.print(cumulative[i][j] +" ");
            }
            System.out.println();
        }
        */
            
        
        int maxSum = Integer.MIN_VALUE;
        
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = i; j < matrix.length; ++j) {
                for (int m = 0; m < matrix[j].length; ++m) {
                    for (int n = m; n < matrix[j].length; ++n) {
                        int sum = cumulative[j][n];
                        if (m > 0) sum -= cumulative[j][m - 1];
                        
                        if (i > 0) sum -= cumulative[i - 1][n];
                        
                        if (i > 0 && m >0) sum += cumulative[i - 1][m - 1];
                        
                        //System.out.println(i + " " + j + "," + m + " " + n + " => " + cumulative[j][n] + " " + sum);
                        if (sum > k) continue;
                        
                        maxSum = Math.max(maxSum, sum);
                    }
                }
            }
        }
        return maxSum;   
    }

}
