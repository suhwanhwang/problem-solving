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

    static long gcd(long a, long b) {
        long c;
        while(b > 0) {
            c = a % b;
            a = b;
            b = c;
        }
        return a;
    }

    public static void main(String[] args) {
	// write your code here
        InputReader in = new InputReader();

        long a = in.nextLong();
        long b = in.nextLong();
        long x = in.nextLong();
        long y = in.nextLong();

        long g = gcd(Math.min(x, y), Math.max(x, y));
        x /= g;
        y /= g;

        System.out.println(Math.min(a/x, b/y));
    }
}
