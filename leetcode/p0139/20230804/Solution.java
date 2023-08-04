class Solution {
    private int[][] dp;
    public boolean wordBreak(String s, List<String> wordDict) {
        dp = new int[s.length()][s.length()];
        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }

        return helper(s, 0, 0, new HashSet<>(wordDict));
    }

    private boolean helper(String s, int start, int index, Set<String> wordSet) {
        if (index >= s.length()) {
            return start == index;
        }

        if (dp[start][index] != -1) {
            return dp[start][index] == 1;
        }

        String cur = s.substring(start, index + 1);
        if (wordSet.contains(cur)) {
            if (helper(s, index + 1, index + 1, wordSet)) {
                dp[start][index] = 1;
                return true;
            }
        }

        dp[start][index] = helper(s, start, index + 1, wordSet) ? 1 : 0;
        return dp[start][index] == 1;
    }
}
