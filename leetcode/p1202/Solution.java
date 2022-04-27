class Solution {
    List<List<Integer>> adj = new ArrayList<>();
    
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        
        for(int i = 0; i < s.length(); ++i) {
            adj.add(new ArrayList<>());
        }
        
        for(List<Integer> p : pairs) {
            int v0 = p.get(0);
            int v1 = p.get(1);
            adj.get(v0).add(v1);
            adj.get(v1).add(v0);
        }
        
        char[] ans = new char[s.length()];
        boolean[] visited = new boolean[s.length()];
        for (int i = 0; i < s.length(); ++i) {
            if (visited[i]) continue;
            
            List<Character> list = new ArrayList<>();
            List<Integer> indexList = new ArrayList<>();
            dfs(s, i, visited, list, indexList);
            Collections.sort(list);
            Collections.sort(indexList);
            for(int j = 0; j < indexList.size(); ++j) {
                ans[indexList.get(j)] = list.get(j);
            }
        }
        return new String(ans);
    }
    private void dfs(String s, int index, boolean[] visited, List<Character> list, List<Integer> indexList) {
        visited[index] = true;
        list.add(s.charAt(index));
        indexList.add(index);
        //System.out.println(index);
        for (int next : adj.get(index)) {
            if (visited[next]) {
                continue;
            }
            dfs(s, next, visited, list, indexList);
        }
    }
}
