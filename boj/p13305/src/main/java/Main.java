import java.io.*;
import java.util.StringTokenizer;
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
        long[] dist = new long[n - 1];
        long[] cost = new long[n];
        for (int i = 0; i < n - 1; ++i) {
            dist[i] = fs.nextInt();
        }
        for (int i = 0; i < n; ++i) {
            cost[i] = fs.nextInt();
        }
        
        System.out.println(solve(n, dist, cost));
    }
    
    static long solve(int n, long[] dist, long[] cost) {
        long ans = 0;
        int cur = 0;
        long d = 0;
        for (int i = cur + 1; i < n; ++i) {
            d += dist[i - 1];
            if (cost[cur] > cost[i] || i == n - 1) {
                ans += cost[cur] * d;
                cur = i;
                d = 0;
            }
        }     
        
        return ans;
    }
}
   