class Solution {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k -1);
        reverse(nums, k, nums.length - 1);
    }
    
    private void reverse(int[] n, int left, int right) {
        for(int i = 0; i < (right - left + 1)/2; ++i) {
            int temp = n[left+i];
            n[left+i] = n[right-i];
            n[right-i] = temp;
        }
    }
}
