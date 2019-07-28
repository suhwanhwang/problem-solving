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
        int[] kb = new int[n];
        for (int i = 0; i < n; ++i) {
            kb[i] = in.nextInt();
        }

        int min = kb[0];
        int max = kb[0];
        for (int i = 0; i < n; ++i) {
            min = Math.min(min, kb[i]);
            max = Math.max(max, kb[i]);
        }
        System.out.println(max - min + 1 - n);
    }
}
