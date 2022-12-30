class Solution {
    private List<List<Integer>> all = new ArrayList<>();
    private boolean[] visited;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        all.clear();
        visited = new boolean[graph.length];
        dfs(graph, 0, new ArrayList<>());
        return all;
    }

    private void dfs(int[][] g, int index, List<Integer> path) {
        if (index == g.length-1) {
            path.add(index);
            all.add(new ArrayList<>(path));
            path.remove(path.size()-1);
            return;
        }

        path.add(index);
        visited[index] = true;
        for (int next : g[index]) {
            if (visited[next]) continue;
            dfs(g, next, path);
        }
        visited[index] = false;
        path.remove(path.size() - 1);
    }
}
