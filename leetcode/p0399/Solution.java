class Solution {
    static class Node {
        int index;
        double weight;
        public Node(int index, double weight) {
            this.index = index;
            this.weight = weight;
        }
        @Override
        public String toString() {
            return index + ":" + weight;
        }
    };
    
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        List<List<Node>> adj = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i < equations.size(); ++i) {
            List<String> eq = equations.get(i);
            for (String s : eq) {
                if (!map.containsKey(s)) {
                    map.put(s, map.size());
                    adj.add(new ArrayList<>());
                }
            }
            
            int first = map.get(eq.get(0));
            int second = map.get(eq.get(1));
            adj.get(first).add(new Node(second, values[i]));
            adj.get(second).add(new Node(first, 1.0/values[i]));
        }
        
        /*
        for (List<Node> node : adj) {
            System.out.println(node);
        }
        */
        double[] ans = new double[queries.size()];
        Arrays.fill(ans, -1);
        for (int i = 0; i < queries.size(); ++i) {
            int first = map.getOrDefault(queries.get(i).get(0), -1);
            int second = map.getOrDefault(queries.get(i).get(1), -1);
            if (first == -1 || second == -1) {
                ans[i] = -1;
                continue;
            }
            //System.out.println(first + "->" + second);
            
            Queue<Node> q = new ArrayDeque<>();
            boolean[] visited = new boolean[adj.size()];
            q.offer(new Node(first, 1));
            visited[first] = true;
            while(!q.isEmpty()) {
                Node cur = q.poll();
                //System.out.println(cur);
                if (cur.index == second) {
                    ans[i] = cur.weight;
                    break;
                }
                for (Node next : adj.get(cur.index)) {
                    if (visited[next.index]) {
                        continue;
                    }
                    visited[next.index] = true;
                    q.offer(new Node(next.index, cur.weight * next.weight));
                }
            }
        }
        return ans;
    }
}
