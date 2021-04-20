/*
https://leetcode.com/problems/n-ary-tree-preorder-traversal/

// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    List<Integer> output = new ArrayList<>();
    public List<Integer> preorder(Node root) {
        dfs(root);
        return output;
    }
    private void dfs(Node node) {
        if(node == null) {
            return;
        }
        
        output.add(node.val);
        for(Node n : node.children) {
            dfs(n);
        }
    }
}
