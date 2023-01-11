class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        Queue<Tree> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[n];
        int[] parents = new int[n];
        
        Tree root = new Tree(0);
        queue.offer(root);
        visited[0] = true;
        parents[0] = -1;
        while (!queue.isEmpty()) {
            Tree currentTree = queue.poll();

            for (int next : adj.get(currentTree.val)) {
                if (visited[next]) {
                    continue;
                }
                Tree nextTree = new Tree(next);
                queue.offer(nextTree);
                visited[next] = true;
                parents[next] = currentTree.val;
                currentTree.child.add(nextTree);
            }
        }

        Set<Edge> edgeSet = new HashSet<>();
        for (int i = 0; i < hasApple.size(); ++i) {
            if (!hasApple.get(i)) {
                continue;
            }

            int current = i;
            while(current != 0) {
                int next = parents[current];
                edgeSet.add(new Edge(Math.min(current, next), Math.max(current, next)));
                current = next;
            }
        }
        return edgeSet.size() * 2;
    }

    private static class Tree {
        private final int val;
        Set<Tree> child = new HashSet<>();
        public Tree(int val) {
            this.val = val;
        }
    }

    private static class Edge {
        private final int from;
        private final int to;
        public Edge(int from, int to) {
            this.from = from;
            this.to = to;
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.from, this.to);
        }

        @Override
        public boolean equals(Object other) {
            if (other instanceof Edge) {
                Edge e = (Edge)other;
                return this.from == e.from && this.to == e.to;
            }
            return false;
        }
    }
}
