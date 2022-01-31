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

class Solution {
    public int maximumWealth(int[][] accounts) {
         return Arrays.stream(accounts)
            .map(account -> Arrays.stream(account).sum())
            .max(Comparator.comparing(x -> x))
             .orElse(0);
    }
}
