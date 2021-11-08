/*
https://leetcode.com/problems/unique-binary-search-trees/description/
*/
class Solution {
    private static final int[] dp = new int[100];
    
    public int numTrees(int n) {
        if (n <= 1) {
            return 1;
        }
        if (dp[n] != 0) {
            return dp[n];
        }
        int sum = 0;
        for (int i = 1; i <= n; ++i) {
            sum += numTrees(i - 1) * numTrees(n - i);
        }
        dp[n] = sum;
        return sum;
    }
}
