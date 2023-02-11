class Solution {
    private static final int INF = 987654321;

    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        
        List<List<Integer>> adjRed = new ArrayList<>();
        List<List<Integer>> adjBlue = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            adjRed.add(new ArrayList<>());
            adjBlue.add(new ArrayList<>());
        }
        for (int[] e : redEdges) {
            adjRed.get(e[0]).add(e[1]);
        }
        for (int[] e : blueEdges) {
            adjBlue.get(e[0]).add(e[1]);
        }

        Queue<int[]> queue = new ArrayDeque<>(); // index, color (0 red, 1 blue)
        int[][] dist = new int[n][2];
        for (int i = 0; i < n; ++i)
            Arrays.fill(dist[i], INF);
    
        dist[0][0] = 0;
        dist[0][1] = 0;
        queue.offer(new int[]{0, 0});
        queue.offer(new int[]{0, 1});
        
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            List<List<Integer>> adj = (cur[1] == 0 ? adjBlue : adjRed);
            for (int next : adj.get(cur[0])) {
                if (dist[next][cur[1] ^ 0x1] > dist[cur[0]][cur[1]] + 1) {
                    dist[next][cur[1] ^ 0x1] = dist[cur[0]][cur[1]] + 1;
                    queue.offer(new int[]{next, cur[1] ^ 0x1});
                }
            }
        }
        int[] result = new int[n];
        for (int i = 0; i < n; ++i) {
            result[i] = Math.min(dist[i][0], dist[i][1]);
            if (result[i] == INF) {
                result[i] = -1;
            }
        }
        return result;
    }
}
