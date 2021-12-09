class Solution {
    List<Set<Integer>> adj;
    boolean[] visited;
    public boolean canReach(int[] arr, int start) {
        
        adj = new ArrayList<>();
        for (int i = 0; i < arr.length; ++i) {
            adj.add(new HashSet<>());
        }
        
        for (int i = 0; i < arr.length; ++i) {
            int left = i - arr[i];
            int right = i + arr[i];
            if (left >= 0) {
                adj.get(i).add(left);
            }
            if (right < arr.length) {
                adj.get(i).add(right);
            }
        }
        
        visited = new boolean[arr.length];
        
        dfs(start);
        
        for (int i = 0; i < arr.length; ++i) {
            if (arr[i] == 0 && visited[i]) {
                return true;
            }
        }
        return false;
    }
    
    private void dfs(int index) {
        visited[index] = true;
        for (int next : adj.get(index)) {
            if (visited[next]) {
                continue;
            }
            dfs(next);
        }
    }
}
