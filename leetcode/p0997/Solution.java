class Solution {
    public int findJudge(int n, int[][] trust) {
        
        List<List<Integer>> adj = new ArrayList<>();
        int[] map = new int[n + 1];
        for (int i = 0; i <= n; ++i) {
            adj.add(new ArrayList<>());
        }
        
        for (int[] t : trust) {
            adj.get(t[0]).add(t[1]);
            map[t[1]]++;
        }
        
        for (int i = 1; i <= n; ++i) {
            if (adj.get(i).isEmpty() && map[i] == n - 1) {
                return i;
            }
        }
        return -1;
    }
}
