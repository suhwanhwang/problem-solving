class Solution {
    int[] dp = new int[100];
    public int tribonacci_dp(int n) {
        int[] t = {0, 1, 1};
        
        if (n <= 2) {
            return t[n];
        }
        if (dp[n]!=0) return dp[n];
        
        dp[n] = tribonacci(n-3) + tribonacci(n-2) + tribonacci(n-1);
        return dp[n];
    }
    public int tribonacci(int n) {
        int[] t = {0, 1, 1};
        if (n <= 2) {
            return t[n];
        }
        for (int i = 3; i <= n; ++i) {
            int sum = t[0] + t[1] + t[2];
            t[0] = t[1];
            t[1] = t[2];
            t[2] = sum;
        }
        return t[2];
    }
}
