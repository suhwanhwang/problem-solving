class Solution {
    private static class Edge {
        int to;
        double prob;
        Edge(int to, double prob) {
            this.to = to;
            this.prob = prob;
        }
    }

    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        List<List<Edge>> adj = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; ++i) {
            int[] e = edges[i];
            double p = succProb[i];
            adj.get(e[0]).add(new Edge(e[1], p));
            adj.get(e[1]).add(new Edge(e[0], p));
        }

        Queue<Edge> queue = new PriorityQueue<>((a,b) -> - Double.compare(a.prob, b.prob));
        double[] prob = new double[n];
        queue.add(new Edge(start, 1));
        prob[start] = 1.0;

        while (!queue.isEmpty()) {
            Edge cur = queue.poll();

            for (Edge next : adj.get(cur.to)) {
                double nextProb = cur.prob * next.prob;
                if (nextProb <= prob[next.to]) continue;

                queue.offer(new Edge(next.to, nextProb));
                prob[next.to] = nextProb;
            }
        }

        return prob[end];
        
    }
}
