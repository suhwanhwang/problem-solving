/*
https://leetcode.com/problems/single-number/description/

Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

Follow up: Could you implement a solution with a linear runtime complexity and without using extra memory?

 

Example 1:

Input: nums = [2,2,1]
Output: 1
Example 2:

Input: nums = [4,1,2,1,2]
Output: 4
Example 3:

Input: nums = [1]
Output: 1
 

Constraints:

1 <= nums.length <= 3 * 104
-3 * 104 <= nums[i] <= 3 * 104
Each element in the array appears twice except for one element which appears only once.
*/
class Solution {
    public int singleNumber_(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            if (numSet.contains(num)) {
                numSet.remove(num);
            } else {
                numSet.add(num);
            }
        }
        return (int)new ArrayList(numSet).get(0);
    }
    
    public int singleNumber(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        int sum = 0;
        int sumOnce = 0;
        for (int num : nums) {
            if (numSet.contains(num)) {
                numSet.remove(num);
            } else {
                numSet.add(num);
                sumOnce += num;
            }
            sum += num;
        }
        return 2 * sumOnce - sum;
    }
}
