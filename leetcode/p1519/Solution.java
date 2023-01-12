class Solution {
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            adj.add(new ArrayList<>());
        }
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        int[] ans = new int[n];
        dfs(adj, labels, ans, -1, 0);
        return ans;
    }

    private int[] dfs(List<List<Integer>> adj, String labels, int[] ans, int prev, int index) {
        int[] labelCounts = new int[26];

        for (int next : adj.get(index)) {
            if (next == prev) {
                continue;
            }

            int[] counts = dfs(adj, labels, ans, index, next);
            for (int i = 0; i < counts.length; ++i) {
                labelCounts[i] += counts[i];
            }
        }
        labelCounts[labels.charAt(index) - 'a']++;
        ans[index] = labelCounts[labels.charAt(index) - 'a'];
        return labelCounts;
    }
}
