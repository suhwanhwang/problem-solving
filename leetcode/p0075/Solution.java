/*
https://leetcode.com/problems/sort-colors/description/

Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Follow up:

Could you solve this problem without using the library's sort function?
Could you come up with a one-pass algorithm using only O(1) constant space?
 

Example 1:

Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
Example 2:

Input: nums = [2,0,1]
Output: [0,1,2]
Example 3:

Input: nums = [0]
Output: [0]
Example 4:

Input: nums = [1]
Output: [1]

*/

class Solution {
    public void sortColors_(int[] nums) {
        if (nums.length == 0) {
            return;
        }
        
        int[] count = new int[3];
        
        for(int i = 0; i < nums.length; ++i) {
            count[nums[i]]++;
        }
        
        int start = 0;
        for(int i = 0; i < count.length; ++i) {
            //System.out.println(i + ", " + count[i]);
            Arrays.fill(nums, start, start + count[i], i);
            start += count[i];
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    
    private int partition(int[] nums, int start, int end) {
        int value = nums[start];
        int index = start;
        for (int i = start + 1; i <= end; ++i) {
            if (nums[i] <= value) {
                index++;
                swap(nums, index, i);
            }
        }
        swap(nums, start, index);
        return index;
    }
    
    private void qsort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        
        int p = partition(nums, start, end);
        qsort(nums, start, p - 1);
        qsort(nums, p + 1, end);
    }
 
    public void sortColors(int[] nums) {
        if (nums.length <= 1) {
            return;
        }
        qsort(nums, 0, nums.length-1);
    }
}
