class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> map = new HashMap<>();
        
        for (String path : paths) {
            String[] tokens = path.split(" ");
            String dir = tokens[0];
            for (int i = 1; i < tokens.length; ++i) {
                int left = tokens[i].indexOf('(');
                int right = tokens[i].indexOf(')');
                String file = tokens[i].substring(0, left);
                String content = tokens[i].substring(left + 1, right);
                List<String> list =
                map.getOrDefault(content, new ArrayList<>());
                list.add(dir + "/" + file);
                map.put(content, list);
            }
        }
        List<List<String>> ans = new ArrayList<>();
        for (List<String> list : map.values()) {
            if (list.size() > 1) {
                ans.add(list);
            }
        }
        return ans;
    }
}
