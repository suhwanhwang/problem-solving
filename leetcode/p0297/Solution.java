/**
 https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
 Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.

Clarification: The input/output format is the same as how LeetCode serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.

 

Example 1:


Input: root = [1,2,3,null,null,4,5]
Output: [1,2,3,null,null,4,5]
 
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
        StringBuilder sb = new StringBuilder();
        
        Queue<TreeNode> q = new LinkedList<>();
        
        q.add(root);
        while(!q.isEmpty()) {
            TreeNode node = q.poll();
            sb.append(node != null ? node.val : "null");
            sb.append(",");
            
            if (node != null) {
                q.offer(node.left);
                q.offer(node.right);
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        //System.out.println(sb);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] token = data.split(",");
        int index = 0;
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = convertTreeNode(token[index++]);
        q.add(root);
        
        while(!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node == null) {
                continue;
            }
            node.left = convertTreeNode(token[index++]);
            node.right = convertTreeNode(token[index++]);
            q.offer(node.left);
            q.offer(node.right);
        }
        
        return root;
    }
    
    private TreeNode convertTreeNode(String token) {
        if (token.equals("null")) {
            return null;
        }
        return new TreeNode(Integer.parseInt(token));
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
