class Solution {
    private int[] dp;
    public int numDecodings(String s) {
        dp = new int[s.length()];
        return numDecodings(s, 0);
    }
    
    private int numDecodings(String s, int index) {
        if (index >= s.length()) {
            return 1;
        }
        
        if (dp[index] != 0) {
            return dp[index];
        }
        
        if (s.charAt(index) == '0') {
            dp[index] = 0;
        } else if (s.length() >= index + 2 && 
            (s.charAt(index) == '1' || 
             (s.charAt(index) == '2' &&'0' <= s.charAt(index+1) && s.charAt(index+1) <= '6'))) {
            dp[index] = numDecodings(s, index + 1) + numDecodings(s, index + 2);         
        } else {
            dp[index] = numDecodings(s, index + 1);
        }
        return dp[index];
    }
}
