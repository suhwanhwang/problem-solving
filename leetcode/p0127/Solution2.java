class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        List<String> list = new ArrayList<>(wordList);
        list.add(0, beginWord);
        
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < list.size(); ++i) {
            adj.add(new ArrayList<>());
        }
        
        for (int i = 0; i < list.size() - 1; ++i) {
            for (int j = i + 1; j < list.size(); ++j) {
                if (!canTrans(list.get(i), list.get(j))) {
                    continue;
                }
                adj.get(i).add(j);
                if (i != 0) {
                    adj.get(j).add(i);
                }
            }
        }
        int start = 0;
        int end = list.indexOf(endWord);
        return getDist(adj, 0, end);
    }
    
    private boolean canTrans(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        int diff = 0;
        for(int i = 0; i < s1.length(); ++i) {
            if (s1.charAt(i) == s2.charAt(i)) {
                continue;
            }
            
            diff++;
        }
        return diff < 2;
    }
    
    private int getDist(List<List<Integer>> adj, int start, int end) {
        boolean[] visited = new boolean[adj.size()];
        
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        visited[start] = true;
        int dist = 1;
        while (!queue.isEmpty()) {
            int len = queue.size();
            while (len-- > 0) {
                int cur = queue.poll();
                if (cur == end) {
                    return dist;
                }
                for (int next : adj.get(cur)) {
                    if (visited[next]) {
                        continue;
                    }
                    queue.offer(next);
                    visited[next] = true;
                }
            }
            dist++;
        }
        return 0;
    }
}
