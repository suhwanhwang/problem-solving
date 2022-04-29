class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];
        
        for (int i = 0; i < graph.length; ++i) {
            if (color[i] == 0) {
                color[i] = 1;
            }
            if (bfs(graph, color, i) == false) {
                return false;
            }
        }
        return true;
    }
    
    private boolean bfs(int[][] graph, int[] color, int start) {
        Queue<Integer> q = new ArrayDeque<>();
        
        q.offer(start);
        while(!q.isEmpty()) {
            int cur = q.poll();
            
            for (int next : graph[cur]) {
                if (color[next] == 0) {
                    q.offer(next);
                    color[next] = color[cur] * -1;
                } else if (color[cur] + color[next] != 0) {
                    return false;
                }
            }    
        }
        return true;
    }
}
