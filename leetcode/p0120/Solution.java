// https://leetcode.com/problems/triangle/
class Solution {
    private int[][] dp = new int[201][201];
    public int minimumTotal(List<List<Integer>> triangle) {
        dp[0][0] = triangle.get(0).get(0);
        for(int r = 1; r < triangle.size(); ++r) {
            int len = triangle.get(r).size();
            for(int c = 0; c < len; ++c) {
                dp[r][c] =  Math.min((c== len-1 ? Integer.MAX_VALUE : dp[r-1][c]), (c==0 ? Integer.MAX_VALUE : dp[r-1][c-1])) + triangle.get(r).get(c);
            }
        }
        int totalMin = Integer.MAX_VALUE;
        for(int c = 0; c < triangle.get(triangle.size()-1).size(); ++c) {
            totalMin = Math.min(totalMin, dp[triangle.size()-1][c]);
        }
        return totalMin;
    }
    
    public int minimumTotal_td(List<List<Integer>> triangle) {
        
        return helper(triangle, 0, 0);
    }
    private int helper(List<List<Integer>> t, int row, int col) {
        if (row >= t.size() || col >= t.get(row).size()) {
            return 0;
        }
        
        if (dp[row][col] != 0) {
            return dp[row][col];
        }
        
        int cur = t.get(row).get(col);
        int sum1 = helper(t, row+1, col);
        int sum2 = helper(t, row+1, col+1);
        dp[row][col] = cur + Math.min(sum1, sum2);
        return dp[row][col];
    }
}
