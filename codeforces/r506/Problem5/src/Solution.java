import java.io.*;
import java.util.*;

public class Solution {

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

    static class Node implements Comparable{
        int depth;
        int index;

        Node(int d, int i) {
            depth = d;
            index = i;
        }

        @Override
        public int compareTo(Object o) {
            Node o1 = (Node)o;
            if (depth == o1.depth) {
                return index - o1.index;
            }
            return -(depth - o1.depth);
        }

        @Override
        public boolean equals(Object obj) {
            Node o = (Node)obj;
            return depth == o.depth && index == o.index;
        }

        @Override
        public int hashCode() {
            return Objects.hash(depth, index);
        }
    }

    static ArrayList<Integer>[] ADJ;
    static TreeSet<Node> TS;
    static int[] D;
    static int[] P;

    public static void main(String[] args) {
        FastReader fs = new FastReader();
        int n = fs.nextInt();
        ADJ = new ArrayList[n + 1];
        for (int i = 0; i <=n; ++i) {
            ADJ[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; ++i) {
            int a = fs.nextInt();
            int b = fs.nextInt();
            ADJ[a].add(b);
            ADJ[b].add(a);
        }
        TS = new TreeSet<>();

        D = new int[n + 1];
        P = new int[n + 1];
        dfs(new boolean[n + 1], 0, 1);

        int ans = 0;

        while(!TS.isEmpty()) {
            Node cur = TS.first();
            Node parent = new Node(D[P[cur.index]], P[cur.index]);
            TS.remove(parent);
            for (int i : ADJ[parent.index]) {
                TS.remove(new Node(D[i], i));
            }
            ans++;
        }
        System.out.println(ans);
    }

    static void dfs(boolean[] visited, int depth, int index) {
        visited[index] = true;
        D[index] = depth;
        if (depth > 2) {
            TS.add(new Node(depth, index));
        }
        for (int i : ADJ[index]) {
            if (!visited[i]) {
                P[i] = index;
                dfs(visited, depth + 1, i);
            }
        }
    }

}
