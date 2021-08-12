/*
https://leetcode.com/problems/flip-string-to-monotone-increasing/
*/
class Solution {
    public int minFlipsMonoIncr(String s) {
        int[] pre = new int[s.length()+1];
        
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            pre[i+1] = pre[i] + (c - '0');
        }
        
        int min = s.length();
        for (int i = 0; i <= s.length(); ++i) {
            int toZero = pre[i];
            int toOne = (s.length() - i) - (pre[s.length()] - pre[i]);
            min = Math.min(min, toZero+toOne);
        }
        return min;
    }
}
