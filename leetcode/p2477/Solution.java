class Solution {
    /*

0(7)

1(3) -> 2     4(2) -> 1      5(1) -> 1

3(2) -> 1     6(1) -> 1

2(1) -> 1

    */

    private long totalFuel = 0;
    
    public long minimumFuelCost(int[][] roads, int seats) {
        
        final List<List<Integer>> adj = new ArrayList<>();
        final int n = roads.length + 1;
        for (int i = 0; i < n; ++i) {
            adj.add(new ArrayList<>());
        }
        for (int[] road : roads) {
            adj.get(road[0]).add(road[1]);
            adj.get(road[1]).add(road[0]);
        }

        totalFuel = 0;
        dfs(adj, 0, -1, seats);
        return totalFuel;
    }

    private long dfs(List<List<Integer>> adj, int index, int parent, int seats) {
        long child = 1;

        for (int next : adj.get(index)) {
            if (next == parent) {
                continue;
            }
            child += dfs(adj, next, index, seats);
        }

        if (index != 0) {
            totalFuel += (int)Math.ceil((double)child / seats);
        }

        return child;
    }
}
