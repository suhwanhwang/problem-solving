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
        long a = in.nextLong();
        long b = in.nextLong();

        System.out.println(Math.min(solve(a, b), solve(b, a)));
    }

    static long solve(long a, long b) {
        long minValue = Long.MAX_VALUE;
        TreeSet<Long> treeSet = new TreeSet<>();
        for(long aW = 1; aW * aW <= a; ++aW) {
            if (a % aW != 0) {
                continue;
            }
            long aH = a / aW;
            treeSet.add(aH);
        }


        for (long abW = 1; abW * abW <= a + b; ++abW) {
            if ((a+ b) % abW != 0) {
                continue;
            }
            long abH = (a + b) / abW;
            Long aH = treeSet.floor(abH);
            if (aH != null && abW >= a/aH) {
                minValue = Math.min(minValue, 2 * (abW + abH));
            }
        }

        return minValue;
    }
}