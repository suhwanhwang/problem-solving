public class Codec {

    private void subSerialize(TreeNode node, int index, Map<Integer, Integer> map) {
        map.put(index, node == null ? null : node.val);
        if (node == null) {
            return;
        }
        
        subSerialize(node.left, index*2+1, map);
        subSerialize(node.right, index*2+2, map);     
    }
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        
        TreeMap<Integer,Integer> map = new TreeMap<>();
        
        subSerialize(root, 0, map);
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i <= map.lastKey(); ++i) {
            Integer value = map.get(i);
            sb.append(value);
            sb.append(",");
        }
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
        }
        System.out.println(sb.toString());
        return sb.toString();
    }
    
    private TreeNode subDeserialize(int index, String[] token) {
        if (index >= token.length) {
            return null;
        }
        
        String s = token[index];
        if (s.equals("null")) {
            return null;
        }
        
        
        TreeNode node = new TreeNode(Integer.parseInt(s));
        node.left = subDeserialize(index * 2 + 1, token);
        node.right = subDeserialize(index * 2 + 2, token);
        return node;
    }
    
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 0) {
            return null;
        }
        
        String[] token = data.split(",");
        TreeNode root = subDeserialize(0,token);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
