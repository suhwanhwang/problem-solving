/*
https://leetcode.com/problems/4sum/
*/
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        Set<List<Integer>> ans = new HashSet<>();
        
        for (int i = 0; i < nums.length - 3; ++i) {
            for (int j = i + 1; j < nums.length - 2; ++j) {
                for (int k = j + 1; k < nums.length - 1; ++k) {
                    int remain = target - (nums[i] + nums[j] + nums[k]);
                    int index = binarySearch(nums, k + 1, nums.length - 1, remain);
                    if (index != -1) {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[k], nums[index]));
                    }
                }
            }
        }
        return new ArrayList(ans);
    }
    
    private int binarySearch(int[] nums, int left, int right, int target) {
        while(left <= right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
