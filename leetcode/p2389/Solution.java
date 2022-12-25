class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);

        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; ++i) {
            ans[i] = getMaxSize(nums, queries[i]);
        }
        return ans;
    }

    private int getMaxSize(int[] nums, int q) {
        int sum = 0;
        for (int i = 0; i < nums.length; ++i) {
            sum += nums[i];
            if (sum > q) {
                return i;
            }
        }
        return nums.length;
    }
}
