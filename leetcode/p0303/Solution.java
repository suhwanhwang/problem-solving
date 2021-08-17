class NumArray {

    private int[] cumulative;
    public NumArray(int[] nums) {
        cumulative = new int[nums.length];
        cumulative[0] = nums[0];
        for(int i = 1; i < nums.length; ++i) {
            cumulative[i] = cumulative[i-1] + nums[i];
        }
    }
    
    public int sumRange(int left, int right) {
        return cumulative[right] - (left > 0 ? cumulative[left-1]:0);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
