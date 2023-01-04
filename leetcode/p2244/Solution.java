class Solution {
    private int[] dp;

    public int minimumRounds(int[] tasks) {
        Arrays.sort(tasks);
        dp = new int[tasks.length];

        int minRound = helper(tasks, 0);
        return (minRound >= INF ? -1 : minRound);
    }

    private static final int INF = 987654321;

    private int helper(int[] tasks, int index) {
        if (index == tasks.length) {
            return 0;
        }

        if (dp[index] != 0) {
            return dp[index];
        }

        int minRound = INF;
        if (index < tasks.length - 1 && tasks[index] == tasks[index + 1]) {
            minRound = 1 + helper(tasks, index + 2);
        }

        if (index < tasks.length - 2 && tasks[index] == tasks[index + 1] && tasks[index] == tasks[index + 2]) {
            minRound = Math.min(minRound, 1 + helper(tasks, index + 3));
        }
        dp[index] = minRound;
        return minRound;
    }
}
