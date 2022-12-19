class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            adj.add(new ArrayList<>());
        }

        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        Queue<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[n];

        q.offer(source);
        visited[source] = true;

        while(!q.isEmpty()) {
            int cur = q.poll();
            if (cur == destination) return true;

            for (int next : adj.get(cur)) {
                if (visited[next]) {
                    continue;
                }
                q.offer(next);
                visited[next] = true;
            }
        }
        return false;
    }
}
