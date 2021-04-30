/*
https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

Follow up: Could you write an algorithm with O(log n) runtime complexity?

 

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
Example 3:

Input: nums = [], target = 0
Output: [-1,-1]
 

Constraints:

0 <= nums.length <= 10^5
-10^9 <= nums[i] <= 10^9
nums is a non-decreasing array.
-10^9 <= target <= 10^9

*/
class Solution2 {
    public int[] searchRange(int[] nums, int target) {
        int low = lowerBound(nums, target);
        int high = upperBound(nums, target);
        
        if (nums.length == 0 || low >= nums.length || nums[low] != target) {
            return new int[]{-1, -1};
        } else {
            return new int[]{low, high -1};
        }
    }
    
    private int lowerBound(int[] nums, int target) {
        int low = 0;
        int high = nums.length;
        while (low < high) {
            int mid = (low + high) >>> 1;
            
            if (nums[mid] >= target) {
                high = mid;
            } else {
                low = mid + 1;    
            }
        }

        return low;
    }
    
    private int upperBound(int[] nums, int target) {
        int low = 0;
        int high = nums.length;
        while (low < high) {
            int mid = (low + high) >>> 1;
            
            if (nums[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid;    
            }
        }
        return low;
    }
}
