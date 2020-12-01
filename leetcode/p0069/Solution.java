/*
https://leetcode.com/problems/sqrtx/

Given a non-negative integer x, compute and return the square root of x.

Since the return type is an integer, the decimal digits are truncated, and only the integer part of the result is returned.


Example 1:

Input: x = 4
Output: 2
Example 2:

Input: x = 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since the decimal part is truncated, 2 is returned.
*/
class Solution {
    public int mySqrt(int x) {
        int l = 1;
        int h = x;
        int ans = 0;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            
            if (mid <= x/mid) {
                ans = mid;
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }
        
        return ans;
    }
}
