class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        List<Set<Integer>> adj = new ArrayList<>();
        
        for (int i = 0; i < n; ++i) {
            adj.add(new HashSet<>());
        }
        
        for (int[] road : roads) {
            adj.get(road[0]).add(road[1]);
            adj.get(road[1]).add(road[0]);
        }
        
        int max = 0;
        for (int i = 0; i < n - 1; ++i) {
            for (int j = i + 1; j < n; ++j) {
                int firstNum = adj.get(i).size();
                int secondNum = adj.get(j).size();
                boolean hasPath = adj.get(i).contains(j);
                max = Math.max(max, firstNum + secondNum - (hasPath ? 1 : 0));
            }
        }
        return max;
    }
}
