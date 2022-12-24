class Solution {
    //  brute-force
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; ++i) {
            adj.add(new ArrayList<>());
        }
        for(int[]e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        int[] ans = new int[n];
        for(int i = 0; i < n; ++i) {
            ans[i] = bfs(adj, i);
        }
        return ans;
    }

    private int bfs(List<List<Integer>> adj, int start) {
        Queue<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[adj.size()];

        q.offer(start);
        visited[start] = true;
        int depth = 0;
        int sum = 0;
        while(!q.isEmpty()) {
            int len = q.size();
            while (len-- > 0) {
                int cur = q.poll();
                sum += depth;
                for (int next : adj.get(cur)) {
                    if (visited[next]) continue;
                    q.offer(next);
                    visited[next] = true;
                }
            }
            depth++;
        }
        return sum;
    }
}
