class Solution {
    public int minJumps(int[] arr) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        
        for(int i = 0; i < arr.length; ++i) {
            Set<Integer> set = map.getOrDefault(arr[i], new HashSet<>());
            set.add(i);
            map.put(arr[i], set);
        }
        
        //bfs
        Queue<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[arr.length];
        int depth = 0;
        q.offer(0);
        visited[0] = true;
        while (!q.isEmpty()) {
            int curLen = q.size();
            
            while (curLen-- > 0) {
                int cur = q.poll();
                
                if (cur == arr.length - 1) {
                    return depth;
                }
                
                if (cur > 0 && !visited[cur - 1]) {
                    q.offer(cur - 1);
                    visited[cur - 1] = true;
                }
                if (cur < arr.length - 1 && !visited[cur + 1]) {
                    q.offer(cur + 1);
                    visited[cur + 1] = true;
                }
                for(int next : map.getOrDefault(arr[cur], new HashSet<>())) {
                    if (visited[next]) continue;
                
                    q.offer(next);
                    visited[next] = true;
                }
            }
            depth++;
        }
        return -1;
    }
}
