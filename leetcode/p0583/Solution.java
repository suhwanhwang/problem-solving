/*
https://leetcode.com/problems/delete-operation-for-two-strings/description/


Given two strings word1 and word2, return the minimum number of steps required to make word1 and word2 the same.

In one step, you can delete exactly one character in either string.

 

Example 1:

Input: word1 = "sea", word2 = "eat"
Output: 2
Explanation: You need one step to make "sea" to "ea" and another step to make "eat" to "ea".
Example 2:

Input: word1 = "leetcode", word2 = "etco"
Output: 4
 

Constraints:

1 <= word1.length, word2.length <= 500
word1 and word2 consist of only lowercase English letters.
*/
class Solution {
    private int[][] dp;
    public int minDistance(String word1, String word2) {
        dp = new int[word1.length()][word2.length()];
        return helper(word1.toCharArray(), 0, word2.toCharArray(), 0);
    }
    
    private int helper(char[] w1, int i1, char[] w2, int i2) {
        if(i1 >= w1.length && i2 >= w2.length) {
            return 0;
        }
        
        if(i1 >= w1.length) {
            return w2.length - i2;
        }
        
        if(i2 >= w2.length) {
            return w1.length - i1;
        }
        
        if(dp[i1][i2] != 0) {
            return dp[i1][i2];
        }
        
        if(w1[i1] == w2[i2]) {
            dp[i1][i2] = helper(w1, i1+1, w2, i2+1);
        } else {
            dp[i1][i2] = 1 + Math.min(
            helper(w1, i1+1, w2, i2),
            helper(w1, i1, w2, i2+1)
            );
        }
        return dp[i1][i2];
    }
}
