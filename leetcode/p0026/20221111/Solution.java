class Solution {
    public int removeDuplicates(int[] nums) {
        int cur = 0;
        for(int i = 1; i < nums.length; ++i) {
            if (nums[cur] < nums[i]) {
                cur++;
                nums[cur] = nums[i];
            }
        }
        //for (int i = cur + 1; nums.length; ++i) { }
        return cur + 1;
    }
}
