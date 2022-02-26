class Solution {
    public int shortestPathLength(int[][] graph) {
        Queue<List<Integer>> q = new ArrayDeque<>(); // state node cost
        Set<List<Integer>> seen = new HashSet<>(); // state node
        
        for(int i = 0; i < graph.length; ++i) {
            q.offer(Arrays.asList((1<<i), i, 0));
            seen.add(Arrays.asList((1<<i), i));
        }
        final int finalState = (1 << graph.length) - 1;
        while(!q.isEmpty()) {
            List<Integer> item = q.poll();
            int state = item.get(0);
            int node = item.get(1);
            int cost = item.get(2);
            
            if (state == finalState) {
                return cost;
            }
            
            for(int next : graph[node]) {
                int nextState = state | (1<<next);
                if (seen.contains(Arrays.asList(nextState,next))) {
                    continue;
                }
                q.offer(Arrays.asList(nextState, next, cost + 1));
                seen.add(Arrays.asList(nextState, next));
            }
        }
        return 0;
    }
}
