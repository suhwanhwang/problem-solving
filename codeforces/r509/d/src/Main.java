import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeSet;

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
        int h = in.nextInt();
        int[][] air = new int[n][2];
        int[] ps = new int[n + 1];

        for (int i = 0; i < n; ++i) {
            air[i][0] = in.nextInt();
            air[i][1] = in.nextInt();
        }
        Arrays.sort(air, (o1, o2) -> o1[0] - o2[0]);

        for (int i = 0; i < n; ++i) {
            ps[i + 1] = ps[i] + air[i][1] - air[i][0];
        }

        System.out.println(solve(n, h, air, ps));
    }

    static long solve(int n, int h, int [][]air, int[] ps) {
        int ans = 0;
        for(int i = 0; i < n; ++i) {
            int lo = i;
            int hi = n-1;
            while(lo < hi) {
                int mid = (lo + hi + 1)/2;
                int range = air[mid][1] - air[i][0];
                int glide = ps[mid + 1] - ps[i] + h;
                if (range < glide) {
                    lo = mid;
                } else {
                    hi = mid - 1;
                }
            }
            ans = Math.max(ans, ps[lo + 1] - ps[i] + h);
        }
        return ans;
    }
}