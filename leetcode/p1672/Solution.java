class Solution {
    public int maximumWealth(int[][] accounts) {
        int max = 0;
        for (int[] account : accounts) {
            int sum = 0;
            for (int w : account) {
                sum += w;
            }
            max = Math.max(sum, max);
        }
        return max;
    }
}
