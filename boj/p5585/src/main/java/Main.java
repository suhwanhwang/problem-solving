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
        
        int cost = fs.nextInt();

        System.out.println(solve(cost));
    }
    
    static int solve(int cost) {
        int rest = 1000 - cost;
        
        int[] change = new int[]{500, 100, 50, 10, 5, 1};
        int count = 0;
        int cur = rest;
        for (int c : change) {
            count += (cur / c);
            cur %= c;
            if (cur == 0) {
                break;
            }
        }
        return count;
    }
}
   