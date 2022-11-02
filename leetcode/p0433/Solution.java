class Solution {
    /*
    public int minMutation(String start, String end, String[] bank) {
        int result = solve(start, end, new HashSet<>(Arrays.asList(bank)));
        return (result == Integer.MAX_VALUE ? -1 : result);
    }
    
    private int solve(String cur, String end, Set<String> bank) {
        if (cur.equals(end)) {
            return 0;
        }
        
        int minMutation = Integer.MAX_VALUE;
        char[] curChars = cur.toCharArray();
        
        for (int i = 0; i < cur.length(); ++i) {
            if (curChars[i] == end.charAt(i)) {
                continue;
            }
            char originChar = curChars[i];
            curChars[i] = end.charAt(i);
            String mutated = new String(curChars);
            if (bank.contains(mutated)) {
                minMutation = Math.min(minMutation, 1 + solve(mutated, end, bank));
            }
            curChars[i] = originChar;
        }
        return minMutation;
    }
    */
    
    public int minMutation(String start, String end, String[] bank) {
        List<String> list = new ArrayList<>();
        list.add(start);
        for (String s : bank) {
            list.add(s);
        }
        
        int endIndex = -1;
        for (int i = 1; i < list.size(); ++i) {
            if (end.equals(list.get(i))) {
                endIndex = i;
                break;
            }
        }
        if (endIndex == -1) {
            return -1;
        }
        
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < list.size(); ++i) {
            adj.add(new ArrayList<>());
        }
        
        for (int i = 0; i < list.size() - 1; ++i) {
            for (int j = i + 1; j < list.size(); ++j) {
                if (canMutate(list.get(i), list.get(j))) {
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        
        Queue<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[list.size()];
        int depth = 0;
        q.offer(0);
        visited[0] = true;
        while(!q.isEmpty()) {
            int len = q.size();
            
            while(len-- > 0) {
                int cur = q.poll();
                if (cur == endIndex) {
                    return depth;
                }
                for (int next : adj.get(cur)) {
                    if (visited[next]) continue;

                    visited[next] = true;
                    q.offer(next);
                }
            }
            depth++;
        }
        return -1;
    }
    
    private boolean canMutate(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int count = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) != t.charAt(i)) {
                count++;
            }        
        }
        return count == 1;
    }
}
