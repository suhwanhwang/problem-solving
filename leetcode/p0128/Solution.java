/*
https://leetcode.com/problems/longest-consecutive-sequence/

Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

Follow up: Could you implement the O(n) solution? 

 

Example 1:

Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
Example 2:

Input: nums = [0,3,7,2,5,8,4,6,0,1]
Output: 9
 

Constraints:

0 <= nums.length <= 104
-109 <= nums[i] <= 109

*/
class Solution {
    public int longestConsecutive_nlogn(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        
        Arrays.sort(nums);
        
        int max = 1;
        int len = 1;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i - 1] == nums[i]) {
                continue;
            } else if (nums[i - 1] + 1 == nums[i]) {
                len++;
                max = Math.max(max, len);
            } else {
                len = 1;
            }
        }
        return max;
    }
 
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        
        int max = 0;
        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int cur = num;
                int len = 0;
                while(set.contains(cur)) {
                    len++;
                    cur++;
                }
                max = Math.max(max, len);
            }
        }
        return max;
    }
}
