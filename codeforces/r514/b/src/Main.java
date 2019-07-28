import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
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
        int m = in.nextInt();
        char[][] s = new char[n][];
        for (int i = 0; i < n; ++i) {
            s[i] = in.next().toCharArray();
        }
        System.out.println(solve(n, m, s) ? "YES" : "NO");
    }

    static boolean solve(int n, int m, char[][] s) {
        char[][] forge = new char[n][m];
        for (int i = 0; i < n; ++i) {
            Arrays.fill(forge[i], '.');
        }

        for (int y = 0; y <= n - 3; ++y) {
            for (int x = 0; x <= m - 3; ++x) {
                if (isOk(x, y, s)) {
                    set(x, y, forge);
                }
            }
        }

        for (int y = 0; y < n; ++y) {
            for (int x = 0; x < m; ++x) {
                if (s[y][x] != forge[y][x]) {
                    return false;
                }
            }
        }

        return true;
    }

    static boolean isOk(int x, int y, char[][] s) {
        for (int i = x; i < x + 3; ++i) {
            for (int j = y; j < y + 3; ++j) {
                if (i == x + 1 && j == y + 1) {
                    continue;
                }

                if (s[j][i] == '.') {
                    return false;
                }
            }
        }
        return true;
    }

    static void set(int x, int y, char[][] f) {
        for (int i = x; i < x + 3; ++i) {
            for (int j = y; j < y + 3; ++j) {
                if (i == x + 1 && j == y + 1) {
                    continue;
                }
                f[j][i] = '#';
            }
        }
    }
}
