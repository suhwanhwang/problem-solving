class Solution {
    private int[][][] dp;
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        dp = new int[s1.length() + 1][s2.length() + 1][2];
        
        return helper(s1, s2, s3, 0, 0, true) || helper(s1, s2, s3, 0, 0, false);
    }
    
    private boolean helper(String s1, String s2, String s3, int i1, int i2, boolean isS1) {
        int index = i1 + i2;
        if (index >= s3.length()) {
            return true;
        }
        
        if (dp[i1][i2][isS1 ? 0 : 1] != 0) {
            return dp[i1][i2][isS1 ? 0 : 1] == 1 ? true : false;
        }
        
        String s = (isS1 ? s1 : s2);
        int sIndex = (isS1 ? i1 : i2);
        int len = 0;
        boolean result = false;
        for (int i = 0; sIndex + i < s.length(); ++i) {
            if (s.charAt(sIndex + i) != s3.charAt(index +i)) {
                break;
            }
            len++;
            
            if (isS1) {
                result = helper(s1, s2, s3, i1 + len, i2, false);
            } else {
                result = helper(s1, s2, s3, i1, i2 + len, true);
            }
            if (result) {
                break;
            }
        }
        dp[i1][i2][isS1 ? 0 : 1] = (result ? 1 : -1);
        return result;
    }
}
