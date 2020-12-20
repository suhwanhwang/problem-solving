/*
https://leetcode.com/problems/largest-rectangle-in-histogram/description/

Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.

 


Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].

 


The largest rectangle is shown in the shaded area, which has area = 10 unit.

 

Example:

Input: [2,1,5,6,2,3]
Output: 10
*/
class Solution {
    
    private int solve(int[] h, int s, int e) {
        if (s == e) {
            return h[s];
        }
        int m = s + (e-s)/2;
        int max = Math.max(solve(h,s,m),solve(h,m+1,e));
        
        int l = m;
        int r = m+1;
        int height = Math.min(h[l],h[r]);
        max = Math.max(max, height * (r - l + 1));
        
        while (l > s || r < e) {
            if (r >= e || (l > s && h[l-1] > h[r+1])) {
                l--;
                height = Math.min(height,h[l]);
            } else {
                r++;
                height = Math.min(height,h[r]);
            }
            max = Math.max(max,height * (r - l + 1));
        }
        return max;
    }
    
    public int largestRectangleArea(int[] heights) {
        if (heights.length == 0) {
            return 0;
        }
        
        return solve(heights, 0, heights.length -1);
    }
}
