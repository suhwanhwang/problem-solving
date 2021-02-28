/*
https://leetcode.com/problems/count-of-smaller-numbers-after-self/

You are given an integer array nums and you have to return a new counts array. The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].

 

Example 1:

Input: nums = [5,2,6,1]
Output: [2,1,1,0]
Explanation:
To the right of 5 there are 2 smaller elements (2 and 1).
To the right of 2 there is only 1 smaller element (1).
To the right of 6 there is 1 smaller element (1).
To the right of 1 there is 0 smaller element.
Example 2:

Input: nums = [-1]
Output: [0]
Example 3:

Input: nums = [-1,-1]
Output: [0,0]
 

Constraints:

1 <= nums.length <= 105
-104 <= nums[i] <= 104

*/
class Solution {
    public List<Integer> countSmaller_n2(int[] nums) {
        List<Integer> smallerList = new ArrayList<>();
        
        for (int i = 0; i < nums.length; ++i) {
            int num = nums[i];
            int count = 0;
            for (int j = i + 1; j < nums.length; ++j) {
                int other = nums[j];
                if (other < num) {
                    count++;
                }
            }
            smallerList.add(count);
        }
        return smallerList;
    }
    
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> helper = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        int n = nums.length;
        
        for(int i = n-1;i>=0;i--){
            int s = lowerBound(helper,nums[i]);
            ans.add(s);
            helper.add(s,nums[i]);
        }
        Collections.reverse(ans);
        return ans;
    }
    
    private int lowerBound(List<Integer> list, int val) {
        int start = 0;
        int end = list.size();
        
        while (start < end) {
            int mid = (start + end) >>> 1;
            
            if (list.get(mid) >= val) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}
