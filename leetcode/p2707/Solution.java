class Solution {
    private int[] dp;
    
    public int minExtraChar(String s, String[] dictionary) {
        dp = new int[s.length()];
        Arrays.fill(dp, -1);
        return helper(s, Arrays.asList(dictionary), 0);
    }
    
    private int helper(String s, List<String> dic, int index) {
        if (index == s.length()) {
            return 0;
        }
        
        if (dp[index] != -1) {
            return dp[index];
        }
        
        int min = s.length() - index;
        
        for (String d : dic) {
            if (s.length() - index < d.length()) {
                continue;
            }
            if (d.equals(s.substring(index, index + d.length()))) {
                min = Math.min(min, helper(s, dic, index + d.length()));
            }
        }
        min = Math.min(min, 1 + helper(s, dic, index + 1));
        dp[index] = min;
        return min;
    }
}
