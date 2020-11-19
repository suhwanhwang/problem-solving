
/*
https://leetcode.com/problems/first-missing-positive/

Given an unsorted integer array nums, find the smallest missing positive integer.

Follow up: Could you implement an algorithm that runs in O(n) time and uses constant extra space.?

 

Example 1:

Input: nums = [1,2,0]
Output: 3
Example 2:

Input: nums = [3,4,-1,1]
Output: 2
*/
class Solution {
    public int firstMissingPositive(int[] nums) {
       if (nums.length == 0) {
           return 1;
       }
       Arrays.sort(nums);
       if (nums[0] > 1) {
           return 1;
       }
       for(int i = 0; i < nums.length; ++i) {
           if (nums[i] <= 0) {
               continue;
           }
           
           if (i > 0 && nums[i-1] + 1 < nums[i]) {
               if (nums[i-1] < 0 && nums[i] == 1) {
                   continue;
               }
               return nums[i-1] < 0 ? 1 : nums[i-1] + 1;
           }
       }
       
       return nums[nums.length - 1] < 0 ? 1 : nums[nums.length - 1] + 1;
    
    }
}
