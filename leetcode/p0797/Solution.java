class Solution {
    private List<List<Integer>> allPath;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        allPath = new ArrayList<>();
        
        List<Integer> path = new ArrayList<>();
        path.add(0);
        dfs(graph,0,path);
        return allPath;
    }
    
    void dfs(int[][] graph, int index, List<Integer> path) {
        if (index == graph.length - 1) {
            allPath.add(new ArrayList<>(path));
            return;
        }
        
        for(int v : graph[index]) {
            path.add(v);
            dfs(graph,v,path);
            path.remove(path.size()-1);
        }
    }
}
