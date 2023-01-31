class Solution {
    public int bestTeamScore(int[] scores, int[] ages) {
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < scores.length; ++i) {
            list.add(new int[]{ages[i], scores[i]});
        }

        Collections.sort(list, (a, b) -> {
            return a[0] == b[0] ? Integer.compare(a[1], b[1]): Integer.compare(a[0], b[0]);
        });
        int[][] dp = new int[list.size() + 1][list.size()];

        for (int i = 0; i < dp.length; ++i) {
            Arrays.fill(dp[i], -1);
        }
        
        return helper(dp, list, 0, -1);
    }

    private int helper(int[][]dp, List<int[]> list, int index, int prev) {
        if (index >= list.size()) {
            //System.out.println(selected);
            return 0;
        }

        if (dp[prev+1][index] != -1) {
            return dp[prev+1][index];
        }

        int score = list.get(index)[1];
        int age = list.get(index)[0];
        
        int max = 0;
        if (prev == -1 || list.get(prev)[1] <= score) {
            max = score + helper(dp,list, index + 1, index);
        }
        max = Math.max(max, helper(dp,list, index + 1, prev));
        dp[prev+1][index] = max;
        return max;
    }

}
