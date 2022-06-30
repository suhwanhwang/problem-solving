class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int target = nums[nums.length / 2];
        int move = 0;
        for (int n : nums) {
            move += Math.abs(n - target);
        }
        return move;
    }
}
