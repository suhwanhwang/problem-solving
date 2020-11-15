/*
https://leetcode.com/problems/remove-duplicates-from-sorted-array/

Given a sorted array nums, 
remove the duplicates in-place 
such that each element appears only once 
and returns the new length.

Do not allocate extra space for another array, 
you must do this by modifying the input array in-place 
with O(1) extra memory.

Input: nums = [1,1,2]
Output: 2, nums = [1,2]
Explanation: Your function should return length = 2, 
with the first two elements of nums being 1 and 2 respectively. 
It doesn't matter what you leave beyond the returned length.

*/
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        
        int writePos = 0;
        int i = 0;
        while(i < nums.length) {
            if (i == nums.length - 1) {
                nums[writePos++] = nums[i];
                break;
            }
            
            int cur = nums[i];
            nums[writePos++] = cur;
            
            while (i < nums.length && cur == nums[i]) {
                i++;
            }
        }
        return writePos;
    }
}
