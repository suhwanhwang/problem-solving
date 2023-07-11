/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i <= 500; ++i) {
            adj.add(new ArrayList<>());
        }

        dfs(root, root.left, adj);
        dfs(root, root.right, adj);

        List<Integer> ans = new ArrayList<>();

        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[500 + 1];
        int depth = 0;
        queue.offer(target.val);
        visited[target.val] = true;
        while (!queue.isEmpty() && depth <= k) {
            int len = queue.size();
            while (len-- > 0) {
                int cur = queue.poll();
                if (depth == k) {
                    ans.add(cur);
                }
                for (int next : adj.get(cur)) {
                    if (visited[next]) {
                        continue;
                    }

                    queue.offer(next);
                    visited[next] = true;
                }
            }
            depth++;
        }
        return ans;
    }

    private void dfs(TreeNode parent, TreeNode root, List<List<Integer>> adj) {
        if (root == null) {
            return;
        }

        adj.get(parent.val).add(root.val);
        adj.get(root.val).add(parent.val);

        dfs(root, root.left, adj);
        dfs(root, root.right, adj);
    }
}
