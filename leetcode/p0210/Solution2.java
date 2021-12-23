class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        int[] inDegree = new int[numCourses];
        for (int i = 0; i < numCourses; ++i) {
            adj.add(new ArrayList<>());
        }
        for (int[] pre : prerequisites) {
            adj.get(pre[1]).add(pre[0]);
            inDegree[pre[0]]++;
        }
        return topologySort(adj, inDegree);
    }
    
    private int[] topologySort(List<List<Integer>> adj, int[] inDegree) {
        int[] result = new int[inDegree.length];
        Queue<Integer> queue = new ArrayDeque<>();
        
        for (int i = 0; i < inDegree.length; ++i) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        // System.out.println(queue);
        // for (int d : inDegree)
        //     System.out.println(d);
        
        for (int i = 0; i < inDegree.length; ++i) {
            if (queue.isEmpty()) {
                return new int[0];
            }
            
            int x = queue.poll();
            result[i] = x;
            for (int y : adj.get(x)) {
                if (--inDegree[y] == 0) {
                    queue.offer(y);
                }
            }
        }
        return result;
    }
}
