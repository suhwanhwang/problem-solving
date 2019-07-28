import java.io.*;
import java.util.*;

public class Main {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
        public FastReader() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }
        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        int nextInt() {
            return Integer.parseInt(next());
        }
        long nextLong() {
            return Long.parseLong(next());
        }
        double nextDouble() {
            return Double.parseDouble(next());
        }
        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
    public static void main(String[] args) {
        FastReader fs = new FastReader();

        int n = fs.nextInt();
        int m = fs.nextInt();
        
        int[] oil = new int[n];
        for (int i = 0; i < n; ++i) {
            oil[i] = fs.nextInt();
        }
        
        List<Edge>[] adj = new List[n];
        for (int i = 0; i < n; ++i) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; ++i) {
            int from = fs.nextInt() - 1; // convert to 0 ~ (n - 1)
            int to = fs.nextInt() - 1; // convert to 0 ~ (n - 1)
            int dist = fs.nextInt();
            adj[from].add(new Edge(to, dist, 0));
            adj[to].add(new Edge(from, dist, 0));
        }

        solve(n, oil, adj);
    }
    static final int MAX_OIL = 2500;
    
    static void solve(int n, int[] oil, List<Edge>[] adj) {
        long[][] dist = new long[MAX_OIL + 1][n];
        for(int i = 0; i < dist.length; ++i) {
            dist[i] = new long[n];
            Arrays.fill(dist[i], Long.MAX_VALUE);
        }
        
        dist[oil[0]][0] = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(0, 0, oil[0]));
        while(!pq.isEmpty()) {
            Edge cur = pq.poll();
            long cost = cur.dist;
            int here = cur.to;
            

            //if (dist[here] < cost) {
            //    continue;
            //}
            if (here == n - 1) {
                System.out.println(cost);
                return;
            }

            // 인접한 정점들을 모두 검사한다
            for (int i = 0; i < adj[here].size(); ++i) {
                int there = adj[here].get(i).to;
                int nextOil = Math.min(cur.oil, oil[there]);
                long nextCost = cost + adj[here].get(i).dist * cur.oil;

                if (dist[cur.oil][there] > nextCost) {
                    dist[cur.oil][there] = nextCost;
                    pq.offer(new Edge(there, nextCost, nextOil));
                }
            }
        }
        
    }

    static class Edge implements Comparable<Edge> {
        int to;
        long dist;
        int oil;

        Edge(int to, long dist, int oil) {
            this.to = to;
            this.dist = dist;
            this.oil = oil;
        }
        
        @Override
        public int compareTo(Edge o) {
            return (int)(dist - o.dist);
        }
    }
}