class Solution {
    public int distributeCookies(int[] cookies, int k) {
        return helper(cookies, k, 0, new int[k]);        
    }

    private int helper(int[] cookies, int k, int index, int[]dist) {
        if (index >= cookies.length) {
            int maxDist = 0;
            for (int d : dist) {
                maxDist = Math.max(maxDist, d);
            }
            return maxDist;
        }

        int minDist = Integer.MAX_VALUE;
        for (int i = 0; i < k; ++i) {
            dist[i] += cookies[index];
            minDist = Math.min(minDist, helper(cookies, k, index + 1, dist));
            dist[i] -= cookies[index];
        }
        return minDist;
    }
}
