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
        char[] c = in.next().trim().toCharArray();
        int[] num = new int[n];
        for (int i = 0; i < n; ++i) {
            num[i] = c[i] - '0';
        }

        System.out.println(solve(num) ? "YES" : "NO");
    }

    static boolean solve(int[] num) {
        int sum = 0;
        for (int i = 0; i < num.length - 1; ++i) {
            sum += num[i];
            if (solveSub(num, i + 1, sum)) {
                return true;
            }
        }
        return false;
    }

    static boolean solveSub(int[] num, int index, int s) {
        if (index >= num.length) {
            return true;
        }

        int sum = 0;
        int p = -1;
        for (int i = index; i < num.length && sum <= s; ++i) {
            sum += num[i];
            if (sum == s) {
                //return solveSub(num, i + 1, s);
                p = i;           
            }
        }
        if (p == -1) {
            return false;
        } else {
            return solveSub(num, p + 1, s);
        }
    }
}
