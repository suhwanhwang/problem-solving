class Solution {
    private Map<Integer,Map<Integer,List<Integer>>> orderMap;

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        orderMap = new TreeMap<>();

        dfs(root, 0, 0);
        List<List<Integer>> ans = new ArrayList<>();
        
        for (Map<Integer, List<Integer>> map : orderMap.values()) {
            List<Integer> colList = new ArrayList<>();
            for (List<Integer> list : map.values()) {
                Collections.sort(list);
                colList.addAll(list);
            }
            ans.add(colList);
        }
        return ans;
    }
    
    private void dfs(TreeNode root, int row, int col) {
        if(root == null) return;
        
        Map<Integer, List<Integer>> map = orderMap.getOrDefault(col, new TreeMap<>());
        List<Integer> list = map.getOrDefault(row, new ArrayList<>());
        list.add(root.val);
        map.put(row, list);
        orderMap.put(col, map);
        
        dfs(root.left, row+1,col-1);
        dfs(root.right, row+1,col+1);
    }
}
