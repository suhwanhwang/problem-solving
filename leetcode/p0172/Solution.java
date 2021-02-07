/*
https://leetcode.com/problems/factorial-trailing-zeroes/

Given an integer n, return the number of trailing zeroes in n!.

Follow up: Could you write a solution that works in logarithmic time complexity?

 

Example 1:

Input: n = 3
Output: 0
Explanation: 3! = 6, no trailing zero.
Example 2:

Input: n = 5
Output: 1
Explanation: 5! = 120, one trailing zero.
Example 3:

Input: n = 0
Output: 0
 

Constraints:

0 <= n <= 104
*/

class Solution {
    private int getCount(int n, int d) {
        if (n % d != 0) {
            return 0;
        }
        
        return 1 + getCount(n/d, d);
    }
    public int trailingZeroes_(int n) {
        
        int twoCount = 0;
        int fiveCount = 0;
        
        for(int i = 1; i <= n; ++i) {
            twoCount += getCount(i, 2);
            fiveCount += getCount(i, 5);
        }
        return Math.min(twoCount, fiveCount);
    }

    public int trailingZeroes(int n) {
        int fiveCount = 0;
        
        while (n >= 5) {
            fiveCount += (n / 5);
            n /= 5;
        }
        return fiveCount;
    }
}
