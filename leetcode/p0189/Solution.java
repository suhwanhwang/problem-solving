/*
https://leetcode.com/problems/rotate-array/

Given an array, rotate the array to the right by k steps, where k is non-negative.

Follow up:

Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
Could you do it in-place with O(1) extra space?
 

Example 1:

Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
Example 2:

Input: nums = [-1,-100,3,99], k = 2
Output: [3,99,-1,-100]
Explanation: 
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]
 

Constraints:

1 <= nums.length <= 2 * 104
-231 <= nums[i] <= 231 - 1
0 <= k <= 105
*/
class Solution {
    private void rotateRight(int[] nums) {
        int tail = nums[nums.length-1];
        
        for (int i = nums.length - 1; i > 0; --i) {
            nums[i] = nums[i - 1];
        }
        nums[0] = tail;
    }
    
    public void rotate_n2(int[] nums, int k) {
        if (nums.length <= 1) {
            return;
        }
        k %= nums.length;
        for (int i = 0; i < k; ++i) {
            rotateRight(nums);
        }
    }


    private void reverse(int[] nums, int s, int e) {
        
        for(int i = s; i < s + (e-s)/2; ++i) {
            int temp = nums[i];
            int other = e - 1 - (i - s);
            nums[i] = nums[other];
            nums[other] = temp;
        }
    }
    public void rotate(int[] nums, int k) {
        if (nums.length <= 1) {
            return ;
        }
        k %= nums.length;
        reverse(nums, 0, nums.length);
        reverse(nums, 0, k);
        reverse(nums, k, nums.length);
    }
}
