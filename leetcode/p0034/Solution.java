/*
https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
Given an array of integers nums sorted 
in ascending order, find the starting 
and ending position of a given target value.
If target is not found in the array, return [-1, -1].
Follow up: Could you write an algorithm 
with O(log n) runtime complexity?
 
Example 1:
               0011223344555
Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:
Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
*/
class Solution {
    private int lowerBound(int[] nums, int t) {
        if (nums.length ==0) {
            return -1;
        }
        int l = 0;
        int r = nums.length-1;
        
        while (l <= r) {
            int m = (l+r)>>>1;
            if (nums[m] < t) {
                l = m + 1;   
            } else {
                r = m - 1;
            }
        }
        return (l < nums.length && nums[l] == t ? l : -1);
    }
    
    private int upperBound(int[] nums, int t) {
        if (nums.length ==0) {
            return -1;
        }
        int l = 0;
        int r = nums.length-1;
        
        while (l <= r) {
            int m = (l+r)>>>1;
            if (nums[m] > t) {
                r = m - 1;   
            } else {
                l = m + 1;
            }
        }
        return (r >=0 && nums[r] == t ? r : -1);
    }
    
    public int[] searchRange(int[] nums, int target) {
        return new int[]{ lowerBound(nums,target), upperBound(nums,target) };
    }
}
