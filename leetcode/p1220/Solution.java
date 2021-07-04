/*
https://leetcode.com/problems/count-vowels-permutation/

Given an integer n, your task is to count how many strings of length n can be formed under the following rules:

Each character is a lower case vowel ('a', 'e', 'i', 'o', 'u')
Each vowel 'a' may only be followed by an 'e'.
Each vowel 'e' may only be followed by an 'a' or an 'i'.
Each vowel 'i' may not be followed by another 'i'.
Each vowel 'o' may only be followed by an 'i' or a 'u'.
Each vowel 'u' may only be followed by an 'a'.
Since the answer may be too large, return it modulo 10^9 + 7.

 

Example 1:

Input: n = 1
Output: 5
Explanation: All possible strings are: "a", "e", "i" , "o" and "u".
Example 2:

Input: n = 2
Output: 10
Explanation: All possible strings are: "ae", "ea", "ei", "ia", "ie", "io", "iu", "oi", "ou" and "ua".
Example 3: 

Input: n = 5
Output: 68
 

Constraints:

1 <= n <= 2 * 10^4
*/
class Solution {
    private enum Vowel {
        A, E, I, O, U
    }
    
    private static final int MOD = (int)1e9 + 7;
    private int[][] dp;

    public int countVowelPermutation(int n) {
        dp = new int[n][Vowel.values().length];
        
        return (int)((perm(n, 0, Vowel.A) 
                      + perm(n, 0, Vowel.E) 
                      + perm(n, 0, Vowel.I) 
                      + perm(n, 0, Vowel.O) 
                      + perm(n, 0, Vowel.U)) % MOD);
    }
    
    private long perm(int n, int index, Vowel cur) {
        if (index == n - 1) {
            return 1;
        }
        
        if (dp[index][cur.ordinal()] != 0) {
            return dp[index][cur.ordinal()];
        }
        
        long ans = 0;
        switch(cur) {
            case A:
                ans = perm(n, index + 1, Vowel.E);
                break;
            case E:
                ans = perm(n, index + 1, Vowel.A) + perm(n, index + 1, Vowel.I);
                break;
            case I:
                ans = perm(n, index + 1, Vowel.A) + perm(n, index + 1, Vowel.E) + perm(n, index + 1, Vowel.O) + perm(n, index + 1, Vowel.U);
                break;
            case O:
                ans = perm(n, index + 1, Vowel.I) + perm(n, index + 1, Vowel.U);
                break;
            case U:
                ans = perm(n, index + 1, Vowel.A);
                break;
        }
        dp[index][cur.ordinal()] = (int)(ans % MOD);
        return dp[index][cur.ordinal()];
    }
}
