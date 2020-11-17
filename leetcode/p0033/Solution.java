/*
https://leetcode.com/problems/search-in-rotated-sorted-array/description/

You are given an integer array nums sorted in ascending order, and an integer target.

Suppose that nums is rotated at some pivot unknown to you beforehand (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

If target is found in the array return its index, otherwise, return -1.

 

Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
*/

class Solution {
    private int sub(int[] nums, int target, int s, int e) {
        if (s == e) {
            return nums[s] == target ? s : -1;
        }
        
        if (nums[s] > nums[e]) {
            int mid = s+(e-s)/2;
            int l = sub(nums, target, s, mid);
            if (l != -1) return l;
            int r = sub(nums, target, mid+1, e);
            if (r != -1) return r;
        } else {
            while (s<=e) {
                int mid = s+(e-s)/2;
                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] > target) {
                    e = mid - 1;
                } else {
                    s = mid + 1;
                }
            }
        }
        return -1;
    }
    
    public int search_(int[] nums, int target) {     
        return sub(nums, target, 0, nums.length - 1);
    }

    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        
        while (l <= r) {
            int m = l + (r-l)/2;
            //System.out.println(l +" " + m + " " + r);
            if (nums[m] == target) {
                return m;
            } else if (nums[l] <= nums[m]) {
                if (nums[l] <= target && target < nums[m]) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            } else if (nums[m] <= nums[r]) {
                if (nums[m] < target && target <= nums[r]) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
        }
        return -1;
    }
}
