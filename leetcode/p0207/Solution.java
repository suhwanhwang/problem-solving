class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; ++i) {
            adj.add(new ArrayList<>());
        }

        for (int[] pre : prerequisites) {
            adj.get(pre[1]).add(pre[0]);
        }

        boolean[] visited = new boolean[numCourses];
        
        for (int i = 0; i < numCourses; ++i) {
            if (visited[i]) {
                continue;
            }
            boolean[] inStack = new boolean[numCourses];
            if (!dfs(adj, i, visited, inStack)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(List<List<Integer>> adj, int index, boolean[] visited, boolean[] inStack) {
        if (inStack[index]) {
            return false;
        }

        if (visited[index]) {
            return true;
        }

        visited[index] = true;
        inStack[index] = true;

        for (int next : adj.get(index)) {
            if (!dfs(adj, next, visited, inStack)) {
                return false;
            }
        }

        inStack[index] = false;
        return true;
    }
}
