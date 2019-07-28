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
        int t = in.nextInt();
        for (int ca = 1; ca <= t; ++ca) {
            long l = in.nextLong();
            long r = in.nextLong();
            System.out.println(solve(l, r));
        }
    }

    static long solve(long l, long r) {
        long count = 0;

        for (long num = l; num <= r; ++num) {
            if (countNonzero(num) <= 3) {
                count++;
            }
        }
        return count;
    }

    static int countNonzero(long num) {
        int count = 0;
        while (num > 0) {
            if (num % 10 > 0) {
                count++;
            }
            num /= 10;
        }
        return count;
    }
}
