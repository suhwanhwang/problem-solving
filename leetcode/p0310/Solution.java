// time limit
class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            adjList.add(new ArrayList<>());
        }
        
        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        //System.out.println(adjList);
        
        int minDepth = n;
        List<Integer> depths = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            int d = getDepth(adjList, i);
            minDepth = Math.min(minDepth, d);
            depths.add(d);
        }
        //System.out.println(depths);
        
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            if(depths.get(i) == minDepth) {
                ans.add(i);
            }
        }
        
        return ans;
    }
    
    private int getDepth(List<List<Integer>> adjList, int rootIndex) {
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[adjList.size()];
        
        int depth = 0;
        queue.add(rootIndex);
        visited[rootIndex] = true;
        
        while(!queue.isEmpty()) {
            int len = queue.size();
            while (len > 0) {
                int cur = queue.poll();
                len--;
                visited[cur] = true;
                for (int next : adjList.get(cur)) {
                    if (!visited[next]) {
                        queue.add(next);
                    }
                }
            }
            depth++;
        }
        return depth;
    }
}
