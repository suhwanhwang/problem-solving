class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        List<List<Integer>> adj = new ArrayList<>();
        int n = edges.length;
        for (int i = 0; i < n; ++i) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; ++i) {
            if (edges[i] == -1) {
                continue;
            }
            adj.get(i).add(edges[i]);
        }

        int[] distances1 = bfs(adj, node1);
        int[] distances2 = bfs(adj, node2);
        for (int d : distances1)
            System.out.println(d);
        System.out.println();
        for (int d : distances2)
            System.out.println(d);

        int min = Integer.MAX_VALUE;
        int node = -1;
        for (int i = 0; i < n; ++i) {
            if (distances1[i] == -1 || distances2[i] == -1) {
                continue;
            }
            int distance = Math.max(distances1[i], distances2[i]);
            if (distance < min) {
                min = distance;
                node = i;
            }
        }
        return node;
    }

    private int[] bfs(List<List<Integer>> adj, int start) {
        Queue<Integer> q = new ArrayDeque<>();
        int[] distances = new int[adj.size()];
        Arrays.fill(distances, -1);

        q.offer(start);
        distances[start] = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int next : adj.get(cur)) {
                if (distances[next] != -1) {
                    continue;
                }

                distances[next] = distances[cur] + 1;
                q.offer(next);
            }
        }
        return distances;
    }
}
