class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        for (int i = 0; i < groupSizes.length; ++i) {
            int size = groupSizes[i];
            List<Integer> list = map.getOrDefault(size, new ArrayList<>());
            list.add(i);
            map.put(size, list);
        }
        
        List<List<Integer>> ans = new ArrayList<>();
        for (int s : map.keySet()) {
            List<Integer> list = map.get(s);
            for (int i = 0; i < list.size() / s; ++i) {
                ans.add(list.subList(i * s, i * s + s));
            }
        }
        return ans;
    }
}
