class Solution {
    public int findDuplicate(int[] nums) {
        /*
        int n = nums.length - 1;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum - n * (n + 1) / 2;
*/
        Arrays.sort(nums);
        for(int i = 1; i < nums.length; ++i) {
            if (nums[i - 1] == nums[i]) {
                return nums[i];
            }
        }
        return 0;
    }
}
