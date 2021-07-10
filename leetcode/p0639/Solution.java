/*
https://leetcode.com/problems/decode-ways-ii/
*/
class Solution {
    private int MOD = (int)1e9 + 7;
    public int numDecodings(String s) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);
        return (int)helper(dp, s, 0);
    }
    
    private long helper(int[] dp, String s, int index) {
        if (index >= s.length()) {
            return 1;
        }
        
        char c = s.charAt(index);
        if (c == '0') {
            return 0;
        }
        
        if (dp[index] != -1) {
            return dp[index];
        }
        
        long one = 0;
        long two = 0;
        
        one = (c == '*' ? 9 : 1) * helper(dp, s, index + 1);
        one %= MOD;
        if (index + 1 == s.length()) {
            dp[index] = (int)one;
            return one;
        }
        
        char next = s.charAt(index + 1);
        if (c == '*') {
            if (next == '*') {
                two = 15; // 11 ~ 19, 21 ~ 26
            } else if (next <= '6') {
                two = 2;
            } else {
                two = 1;
            }
        } else if (c == '1') {
            if (next == '*') {
                two = 9; // 11 ~ 19
            } else {
                two = 1;
            }
        } else if (c == '2') {
            if (next == '*') {
                two = 6; // 21 ~ 26
            } else if (next <= '6') {
                two = 1;
            }
        }
        two *= helper(dp, s, index + 2);
        two %= MOD;
        dp[index] = (int)((one + two) % MOD);
        return dp[index];
    }
}
