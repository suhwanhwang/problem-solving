class Solution {
    int[] dpAlice;
    int[] dpBob;
    public boolean winnerSquareGame(int n) {
        dpAlice = new int[n + 1];
        Arrays.fill(dpAlice, -1);
        dpBob = new int[n + 1];
        Arrays.fill(dpBob, -1);
        return solve(n, true);
    }
    
    private boolean solve(int n, boolean isAlice) {
        if (n == 0) {
            return !isAlice;
        }
        
        int [] dp = (isAlice? dpAlice : dpBob);
        
        if (dp[n] != -1) {
            return dp[n] == 1;
        }
        for (int i = 1; i * i <= n; ++i) {
            boolean ret = solve(n - i*i, !isAlice);
            if (ret == isAlice) {
                dp[n] = isAlice ? 1 : 0;
                return isAlice;
            }
        }
        dp[n] = !isAlice ? 1 : 0;
        return !isAlice;
    }
}
