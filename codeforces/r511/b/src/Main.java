import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static class InputReader {
        private final BufferedReader br;
        private StringTokenizer st;

        public InputReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public String next() {
            while(st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }

    public static void main(String[] args) {
	// write your code here
        InputReader in = new InputReader();
        int n = in.nextInt();
        int[][] p = new int[n][2];
        for (int i = 0; i < n; ++i) {
            p[i][0] = in.nextInt();
            p[i][1] = in.nextInt();
        }

        // y = -x + c
        // c = x + y
        int max = 0;
        for (int i = 0; i < n; ++i) {
            max = Math.max(max, p[i][0] + p[i][1]);
        }

        System.out.println(max);
    }
}
