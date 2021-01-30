/*
https://leetcode.com/problems/find-peak-element/

A peak element is an element that is strictly greater than its neighbors.

Given an integer array nums, find a peak element, and return its index. If the array contains multiple peaks, return the index to any of the peaks.

You may imagine that nums[-1] = nums[n] = -∞.

 

Example 1:

Input: nums = [1,2,3,1]
Output: 2
Explanation: 3 is a peak element and your function should return the index number 2.
*/
class Solution {
    public int findPeakElement(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
        
        for (int i = 0; i < nums.length; ++i) {
            if (i == 0) {
                if (nums[i] > nums[i+1]) {
                    return 0;
                }
            } else if (i == nums.length - 1) {
                if (nums[i - 1] < nums[i]) {
                    return i;
                }
            } else {
                if (nums[i-1] < nums[i] && nums[i] > nums[i+1]) {
                    return i;
                }
            }
        }
        return -1;
    }
}
