class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Queue<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[rooms.size()];

        q.offer(0);
        visited[0] = true;

        while(!q.isEmpty()) {
            int cur = q.poll();
            for (int next : rooms.get(cur)){
                if (visited[next]) continue;
                q.offer(next);
                visited[next] = true;
            }
        }
        for(boolean v : visited) {
            if (!v) return false;
        }
        return true;

    }
}
