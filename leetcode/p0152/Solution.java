/*
https://leetcode.com/problems/maximum-product-subarray/

Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.

Example 1:

Input: [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
Example 2:

Input: [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.

*/
class Solution {
    public int maxProduct_n2(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; ++i) {
            int prod = 1;
        
            for (int j = i; j < nums.length; ++j) {
                prod *= nums[j];
                max = Math.max(max, prod);
            }
        }
        
        return max;
    }
    
    public int maxProduct(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        
        int max, min, ans;
        max = min = ans = nums[0];
        
        for (int i = 1; i < nums.length; ++i) {
            int tempMax = Math.max(nums[i], Math.max(max * nums[i], min * nums[i]));
            min = Math.min(nums[i], Math.min(max * nums[i], min * nums[i]));
            max = tempMax;
            ans = Math.max(ans, max);
        }
        
        return ans;
    }
}
