class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<List<Integer>, List<String>> map = new HashMap<>();
        
        for (String s : strs) {
            List<Integer> countList = getCountList(s);
            List<String> list = map.getOrDefault(countList, new ArrayList<>());
            list.add(s);
            map.put(countList, list);
        }
        return new ArrayList<>(map.values());
    }
    
    private List<Integer> getCountList(String s) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 26; ++i) {
            list.add(0);
        }
        
        for (char c : s.toCharArray()) {
            int index = c - 'a';
            list.set(index, list.get(index) + 1);
        }
        return list;
    }
}
