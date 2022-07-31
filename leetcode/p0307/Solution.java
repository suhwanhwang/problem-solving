class NumArray {
    private int[] tree; // fenwick tree

    public NumArray(int[] nums) {
        tree = new int[nums.length + 1];
        
        for (int i = 0; i < nums.length; ++i) {
            add(i, nums[i]);
        }
    }
    
    private int sum(int pos) {
        ++pos;
        int ret = 0;
        while(pos > 0) {
            ret += tree[pos];
            pos &= (pos - 1);
        }
        return ret;
    }
    
    private void add(int pos, int val) {
        ++pos;
        while (pos < tree.length) {
            tree[pos] += val;
            pos += (pos & -pos);
        }
    }
    
    public void update(int index, int val) {
        int original = sum(index) - sum(index - 1);
        add(index, val - original);
    }
        
    public int sumRange(int left, int right) {
        return sum(right) - sum(left - 1);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */
