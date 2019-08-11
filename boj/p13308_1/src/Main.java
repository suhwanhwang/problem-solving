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
        String inputFile = /*"13308.in"; // */"test_in.txt";
        if ("true".equals(System.getProperty("use_text_input"))) {
            try {
                System.setIn(new FileInputStream(new File(inputFile)));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return;
            }
        }

        FastReader fs = new FastReader();

        int n = fs.nextInt();
        int m = fs.nextInt();
        int[] gas = new int[n];
        List<Edge>[] adj = new List[n];
        for (int i = 0; i < n; ++i) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; ++i) {
            gas[i] = fs.nextInt();
        }

        for (int i = 0; i < m; ++i) {
            int from = fs.nextInt() - 1; // convert to 0 ~ (n - 1)
            int to = fs.nextInt() - 1; // convert to 0 ~ (n - 1)
            int dist = fs.nextInt();
            adj[from].add(new Edge(to, dist));
            adj[to].add(new Edge(from, dist));
        }

        System.out.println(solve(n, adj, gas, 0));
    }

    static final int MAX_COST = 2500;
    static final int MAX_N = 2500;

    static long solve(int n, List<Edge>[] adj, int[] gas, int src) {
        long[][] dist = new long[MAX_N + 1][MAX_COST + 1]; // dp of dist[vertex][gas price]
        for (int i = 0; i < MAX_N; ++i) {
            Arrays.fill(dist[i], -1);
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(src, 0, gas[src]));
        while(!pq.isEmpty()) {
            Edge cur = pq.poll();
            long cost = cur.dist;
            int here = cur.to;

            if (dist[here][cur.gas] != -1) {
                continue;
            }
            dist[here][cur.gas] = cost;
            if (here == n - 1) {
                return cost;
            }
            // 인접한 정점들을 모두 검사한다
            for (int i = 0; i < adj[here].size(); ++i) {
                int there = adj[here].get(i).to;
                long nextCost = cost + adj[here].get(i).dist * cur.gas;
                int nextGas = Math.min(cur.gas, gas[there]);

                if (dist[there][nextGas] == -1) {
                    pq.offer(new Edge(there, nextCost, nextGas));
                }
            }
        }
        return 0;
    }

    static class Edge implements Comparable<Edge> {
        int to;
        long dist;
        int gas; // for dijkstra()

        Edge(int to, long dist) {
            this(to, dist, 0);
        }
        Edge(int to, long dist, int gas) {
            this.to = to;
            this.dist = dist;
            this.gas = gas;
        }

        @Override
        public int compareTo(Edge o) {
            return (int)(dist - o.dist);
        }
    }
}

