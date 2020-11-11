/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        
        Queue<TreeNode> q = new LinkedList<>();
        
        StringBuilder sb = new StringBuilder();
        
        q.offer(root);
        
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node == null) {
                sb.append("null,");
                continue;
            }
            
            sb.append(node.val);
            sb.append(",");
            q.offer(node.left);
            q.offer(node.right);
        }
        
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
        }
        System.out.println(sb.toString());
        return sb.toString();
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 0) {
            return null;
        }
        String[] token = data.split(",");
        
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(token[0]));
        
        q.offer(root);
        for (int i = 1; i < token.length; i += 2) {
            
            TreeNode node = q.poll();
            
            if (token[i].equals("null")) {
                node.left = null;
            } else {
                node.left = new TreeNode(Integer.parseInt(token[i]));
                q.offer(node.left);
            }
            
            
            if (token[i+1].equals("null")) {
                node.right = null;
            } else {
                node.right = new TreeNode(Integer.parseInt(token[i+1]));
                q.offer(node.right);
            }
        }
        
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
