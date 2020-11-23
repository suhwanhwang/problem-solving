/*
https://leetcode.com/problems/wildcard-matching/

Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*' where:

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).
The matching should cover the entire input string (not partial).

 

Example 1:

Input: s = "aa", p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".
*/


class Solution {

    // time out
    private boolean isMatchSub(String s, String p, int si, int pi) {
        //System.out.println("si : " + si + " pi: " + pi);
        if (si == s.length() && pi == p.length()) {
            return true;
        }
        if (pi == p.length() || (si == s.length() && p.charAt(pi) != '*')) {
            return false;
        }
        
        char pc = p.charAt(pi);
        //System.out.println("pc : " + pc + " si: " + si);
        if (pc == '*') {
            for (int i = 0; i <= s.length() - si; ++i) {
                if (isMatchSub(s, p, si + i, pi + 1)) {
                    return true;
                }
            }
            return false;
        } else if (pc == '?') {
            return isMatchSub(s, p, si + 1, pi + 1);
        } else {
            if (pc == s.charAt(si)) {
                return isMatchSub(s, p, si + 1, pi + 1);
            } else {
                return false;
            }
        }
    }
    
    public boolean isMatch(String s, String p) {
        return isMatchSub(s, p, 0, 0);
    }
}
