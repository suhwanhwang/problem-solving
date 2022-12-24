class Solution {
    private static final int MOD = (int)1e9 + 7;
    private int[][] dp;
    public int numTilings(int n) {
        dp = new int[3][n];
        for (int i = 0; i < dp.length; ++i) {
            Arrays.fill(dp[i], -1);
        }

        int[][] d = new int[2][n];
        helper(d, 0);
        return helper(d, 0);
    }

    private int helper(int[][] d, int col) {
        if (col == d[0].length) {
            return 1;
        }

        /*
        0  1  2
        00 10 00 
        00 00 10
        */
        if (d[0][col] == 0 && d[1][col] == 0) {
            if (dp[0][col] != -1) {
                return dp[0][col];
            }

            int sum = 0;
            if (col + 1 < d[0].length) {
                // hori =
                d[0][col] = 1;
                d[1][col] = 1;
                d[0][col + 1] = 1;
                d[1][col + 1] = 1;
                sum += helper(d, col + 2);
                sum %= MOD;

                // tro 1 r
                d[1][col + 1] = 0;
                sum += helper(d, col + 1);
                sum %= MOD;

                // tro 2 L
                d[0][col + 1] = 0;
                d[1][col + 1] = 1;
                sum += helper(d, col + 1);
                sum %= MOD;
                
                d[1][col + 1] = 0;
            }
            
            // vert
            d[0][col] = 1;
            d[1][col] = 1;
            sum += helper(d, col + 1);
            sum %= MOD;

            d[0][col] = 0;
            d[1][col] = 0;
            dp[0][col] = sum;
            return sum;
        } else if (d[0][col] == 1 && d[1][col] == 0) {
            // 1 0
            // 0 0
            if (dp[1][col] != -1) {
                return dp[1][col];
            }

            int sum = 0;
            if (col + 1 < d[0].length) {
                // vert
                d[1][col] = 1;
                d[1][col + 1] = 1;
                sum += helper(d, col + 1);
                sum %= MOD;

                // tro
                d[0][col + 1] = 1;
                sum += helper(d, col + 2);
                sum %= MOD;

                d[0][col + 1] = 0;
                d[1][col] = 0;
                d[1][col + 1] = 0;
            }
            dp[1][col] = sum;
            return sum;
        } else if (d[0][col] == 0 && d[1][col] == 1) {
            // 0 0
            // 1 0
            if (dp[2][col] != -1) {
                return dp[2][col];
            }

            int sum = 0;
            if (col + 1 < d[0].length) {
                // vert
                d[0][col] = 1;
                d[0][col + 1] = 1;
                sum += helper(d, col + 1);
                sum %= MOD;

                // tro
                d[1][col + 1] = 1;
                sum += helper(d, col + 2);
                sum %= MOD;

                d[1][col + 1] = 0;
                d[0][col] = 0;
                d[0][col + 1] = 0;
            }
            dp[2][col] = sum;
            return sum;
        }
        return 0;
    }
}
