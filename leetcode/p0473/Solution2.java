class Solution {
    private boolean[] isVisited;
    public boolean makesquare(int[] matchsticks) {
        int total = 0;
        for (int m : matchsticks) {
            total += m;
        }
        if (total % 4 != 0) {
            return false;
        }
        
        Arrays.sort(matchsticks);
        int oneLength = total / 4;
        int[] sum = new int[4];
        return dfs(matchsticks, matchsticks.length - 1, sum, oneLength);
    }
    
    private boolean dfs(int[] matchsticks, int index, int[] sum, int oneLength) {
        if (index < 0) {
            return sum[0] == sum[1] && sum[1] == sum[2] && sum[2] == sum[3];
        }
        
        for (int j = 0; j < 4; ++j) {
            if (sum[j] + matchsticks[index] > oneLength) {
                continue;
            }

            sum[j] += matchsticks[index];
            if (dfs(matchsticks, index - 1, sum, oneLength)) {
                return true;
            }
            sum[j] -= matchsticks[index];
        }
        
        return false;
    }
}
