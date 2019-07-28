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
        int[][] cost = new int[n][3];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < 3; ++j) {
                cost[i][j] = fs.nextInt();
            }
        }

        System.out.println(solve(cost));
    }
    
    static int solve(int[][] cost) {
        int n = cost.length;
        int[] prev = new int[3];
        int[] tmp;
        prev[0] = cost[0][0];
        prev[1] = cost[0][1];
        prev[2] = cost[0][2];
        for (int i = 1; i < n; ++i) {
            tmp = new int[3];
            tmp[0] = Math.min(prev[1], prev[2]) + cost[i][0];
            tmp[1] = Math.min(prev[0], prev[2]) + cost[i][1];
            tmp[2] = Math.min(prev[0], prev[1]) + cost[i][2];
            prev = tmp;
        }
        
        return Math.min(prev[0], Math.min(prev[1], prev[2]));
    }
}
   