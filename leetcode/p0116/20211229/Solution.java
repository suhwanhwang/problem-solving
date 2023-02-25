class Solution {
    public Node connect(Node root) {
        Queue<Node> q = new ArrayDeque<>();
        
        if (root != null)
            q.add(root);
        
        while(!q.isEmpty()) {
            int len = q.size();
            
            Node prev = new Node();
            while(len-- > 0) {
                Node node = q.poll();
                if (node.left != null)
                    q.offer(node.left);
                if (node.right != null)
                    q.offer(node.right);
                prev.next = node;
                prev = node;
            }
        }
        return root;
    }
}
