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
        String inputFile = "test_in.txt";
        if (true) {
            try {
                System.setIn(new FileInputStream(new File(inputFile)));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return;
            }
        }

        FastReader fs = new FastReader();

        int v = fs.nextInt();
        int e = fs.nextInt();
        int start = fs.nextInt() - 1; // convert to 0 ~ (n - 1)
        List<Edge>[] adj = new List[v];
        for (int i = 0; i < v; ++i) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < e; ++i) {
            int from = fs.nextInt() - 1; // convert to 0 ~ (n - 1)
            int to = fs.nextInt() - 1; // convert to 0 ~ (n - 1)
            int dist = fs.nextInt();
            adj[from].add(new Edge(to, dist));
        }

        solve(v, adj, start);
    }

    static void solve(int n, List<Edge>[] adj, int src) {
        long[] dist = dijkstra(n, adj, src);
        for (long d : dist) {
            if (d == Long.MAX_VALUE) {
                System.out.println("INF");
            } else {
                System.out.println(d);
            }
        }
    }

    static long[] dijkstra(int n, List<Edge>[] adj, int src) {
        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[src] = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(src, 0));
        while(!pq.isEmpty()) {
            Edge cur = pq.poll();
            long cost = cur.dist;
            int here = cur.to;

            if (dist[here] < cost) {
                continue;
            }

            // 인접한 정점들을 모두 검사한다
            for (int i = 0; i < adj[here].size(); ++i) {
                int there = adj[here].get(i).to;
                long nextCost = cost + adj[here].get(i).dist;

                if (dist[there] > nextCost) {
                    dist[there] = nextCost;
                    pq.offer(new Edge(there, nextCost));
                }
            }
        }
        return dist;
    }

    static class Edge implements Comparable<Edge> {
        int to;
        long dist;

        Edge(int to, long dist) {
            this.to = to;
            this.dist = dist;
        }

        @Override
        public int compareTo(Edge o) {
            return (int)(dist - o.dist);
        }
    }
}

