// https://leetcode.com/problems/longest-common-subsequence/
class Solution {
    private int[][] dp;
    public int longestCommonSubsequence(String text1, String text2) {
        dp = new int[text1.length()][text2.length()];
        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }
        return helper(text1, 0, text2, 0);
    }
    
    private int helper(String text1, int index1, String text2, int index2) {
        if (index1 >= text1.length() || index2 >= text2.length()) {
            return 0;
        }
        
        if (dp[index1][index2] != -1) {
            return dp[index1][index2];
        }
        
        if (text1.charAt(index1) == text2.charAt(index2)) {
            dp[index1][index2] = 1 + helper(text1, index1 + 1, text2, index2 + 1);
        } else {
            dp[index1][index2] = Math.max(helper(text1, index1 + 1, text2, index2), helper(text1, index1, text2, index2 + 1));
        }
        
        return dp[index1][index2];
    }
}
