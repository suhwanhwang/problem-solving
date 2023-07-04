class Solution {
    public int singleNumber(int[] nums) {
        int ans = 0;

        for (int i = 0; i < 32; ++i) {
            int sum = 0;
            for (int num : nums) {
                sum += (num >> i) & 0x1;
            }
            sum %= 3;
            ans |= (sum << i);
        }
        return ans;
    }
    /*
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
    */
}
