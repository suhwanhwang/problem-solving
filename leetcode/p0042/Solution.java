/*
https://leetcode.com/problems/trapping-rain-water/

Given n non-negative integers representing an elevation map where the width of each bar is 1, 
compute how much water it can trap after raining.

 

Example 1:


Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. 
In this case, 6 units of rain water (blue section) are being trapped.
Example 2:

Input: height = [4,2,0,3,2,5]
Output: 9
*/
class Solution {
    public int trap2(int[] height) {
        if (height.length <= 2) {
            return 0;
        }
        
        int maxH = 0;
        for (int i = 0; i < height.length; ++i) {
            maxH = Math.max(maxH, height[i]);
        }
        
        int total = 0;
        
        for (int i = 1; i <= maxH; ++i) {
            int partial = 0;
            boolean started = false;
            
            for (int j = 0; j < height.length; ++j) {
                if (height[j] >= i) {
                    total += partial;
                    partial = 0;
                    started = true;
                } else {
                    if (started) {
                        partial++;
                    }
                }
            }
        }
        return total;
    }
    
    public int trap(int[] height) {
        if (height.length <= 2) {
            return 0;
        }
        
        int left = 0;
        int right = height.length - 1;
        int leftMax = height[0];
        int rightMax = height[height.length - 1];
        int total = 0;
        while (left <= right) {
            
            if (leftMax < rightMax) {
                
                if (leftMax <= height[left]) {
                    leftMax = height[left];
                } else {
                    total += leftMax - height[left];
                    //System.out.println("left : " + left + " " + total);
                }
                left++;
            } else {
                if (rightMax <= height[right]) {
                    rightMax = height[right];
                } else {
                    total += rightMax - height[right];
                    //System.out.println("right : " + right + " " + total);
                }
                right--;
            }
        }
        return total;
    }
    
}
