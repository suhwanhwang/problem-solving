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
        boolean isHard = false;
        for (int i = 0; i < n; ++i) {
            int a = in.nextInt();
            if (a == 1) {
                isHard = true;
            }
        }
        System.out.println(isHard ? "HARD" : "EASY");
    }
}
