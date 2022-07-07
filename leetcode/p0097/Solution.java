class Solution {
    int[][] dp;
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        
        dp = new int[s1.length() + 1][s2.length() + 1];
        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }
        
        return helper(s1.toCharArray(), 0, s2.toCharArray(), 0, s3.toCharArray());
    }
    
    private boolean helper(char[] s1, int i1, char[] s2, int i2, char[] s3) {
        if (i1 == s1.length && i2 == s2.length) {
            return true;
        }
        if (dp[i1][i2] != -1) {
            return dp[i1][i2] == 1;
        }
        
        boolean isOk = false;
        if (i1 < s1.length && s1[i1] == s3[i1 + i2]) {
            isOk = helper(s1, i1 + 1, s2, i2, s3);
        }
        if (isOk) return true;
        
        if (i2 < s2.length && s2[i2] == s3[i1 + i2]) {
            isOk = helper(s1, i1, s2, i2 + 1, s3);
        }
        dp[i1][i2] = isOk ? 1 : 0;
        return isOk;
    }
}
