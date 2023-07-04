class Solution {
    public int singleNumber(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        Arrays.sort(nums);
        int prev = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; ++i) {
            if (prev == nums[i]) {
                count++;
            } else {
                if (count != 3) {
                    return prev;
                } else {
                    prev = nums[i];
                    count = 1;
                }
            }
        }
        return prev;
    }
}
