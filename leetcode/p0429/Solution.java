/*
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
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> levels = new ArrayList<>();
        if (root == null) {
            return levels;
        }
        
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int len = queue.size();
            List<Integer> curLevel = new ArrayList<>();
            
            while(len-- > 0) {
                Node curNode = queue.poll();
                curLevel.add(curNode.val);
                
                for (Node node : curNode.children) {
                    queue.offer(node);
                }
            }
            levels.add(curLevel);
        }
        
        return levels;
    }
}
