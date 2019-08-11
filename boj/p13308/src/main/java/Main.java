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
        List<Edge>[] adj = new List[n];
        for (int i = 0; i < n; ++i) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; ++i) {
            oil[i] = fs.nextInt();
        }

        for (int i = 0; i < m; ++i) {
            int from = fs.nextInt() - 1; // start from 0
            int to = fs.nextInt() - 1;
            int dist = fs.nextInt();
            adj[from].add(new Edge(to, dist));
            adj[to].add(new Edge(from, dist));
        }
        
        System.out.println(solve(n, adj, oil));
    }
    
    static long solve(int n, List<Edge>[] adj, int[] oil) {
        int[] dist = dijkstra(n, adj, oil, 0);

        return dist[n - 1];
    }

    static final int INF = 987654321;
    static int[] dijkstra(int n, List<Edge>[] adj, int[] oil, int src) {
        int[] dist = new int[n];
        Arrays.fill(dist, INF);
        dist[src] = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(src, 0, oil[src]));
        while(!pq.isEmpty()) {
            Edge top = pq.poll();
            int cost = top.dist * top.oil;
            int here = top.to;
            // 만약 지금 꺼낸 것보다 더 짧은 경로를 알고 있다면 지금 꺼낸 것을 무시한다
            if (dist[here] < cost) {
                continue;
            }
            // 인접한 정점들을 모두 검사한다
            for (int i = 0; i < adj[here].size(); ++i) {
                int there = adj[here].get(i).to;
                int nextDist = cost + adj[here].get(i).dist * top.oil;
                // 더 짧은 경로를 발견하면, dist[] 를 갱신하고 우선 순위 큐에 넣는다
                if (dist[there] > nextDist) {
                    dist[there] = nextDist;
                    pq.offer(new Edge(there, nextDist, Math.min(top.oil, oil[there])));
                }
            }
        }
        return dist;
    }

    static class Edge implements Comparable<Edge> {
        int to;
        int dist;
        int oil;

        Edge(int to, int dist) {
            this(to, dist, 0);
        }

        Edge(int to, int dist, int oil) {
            this.to = to;
            this.dist = dist;
            this.oil = oil;
        }

        @Override
        public int compareTo(Edge o) {
            return dist - o.dist;
        }
    }
}
   