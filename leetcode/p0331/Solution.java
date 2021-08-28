// https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/
class Solution {
    private int index;
    public boolean isValidSerialization(String preorder) {
        String[] nodes = preorder.split(",");
        index = 0;
        dfs(nodes);
        return index == nodes.length-1;
    }
    
    private void dfs(String[] nodes) {
        if (index >= nodes.length) return;
        
        if (nodes[index].equals("#")) return;
        
        index++;
        dfs(nodes);
        
        index++;
        dfs(nodes);
    }
}
