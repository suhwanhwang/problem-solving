class Solution {
    public List<List<Integer>> generate(int numRows) {
        
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(Arrays.asList(1));
        for (int i = 1; i < numRows; ++i) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            
            List<Integer> prev = ans.get(i - 1);
            for (int j = 0; j < prev.size() - 1; ++j) {
                list.add(prev.get(j) + prev.get(j + 1));
            }
            list.add(1);
            
            ans.add(list);
        }
        
        return ans;
    }
}
