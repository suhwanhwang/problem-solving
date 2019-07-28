import java.io.*;
import java.util.*;

public class Solution {

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
        int n = fs.nextInt();
        int k = fs.nextInt();
        long[] num = new long[n];
        for (int i = 0; i < n; ++i) {
            num[i] = fs.nextInt();
        }

        System.out.println(solve(n, k, num));
    }

    static int solveSmall(int n, int k, int[] num) {
        int count = 0;

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i == j) {
                    continue;
                }

                int log10 = (int) Math.log10(num[j]);
                long number = (long) num[i] * (long) Math.pow(10, (log10 + 1)) + num[j];
                if (number % k == 0) {
                    count++;
                }
            }
        }
        return count;
    }

    static long solve(int n, int k, long[] num) {
        long count = 0;

        HashMap<Long, HashSet<Integer>>[] map = new HashMap[10];
        for (int i = 0; i < 10; ++i) {
            map[i] = new HashMap<>();
        }

        for (int i = 0; i < n; ++i) {
            int log = (int) Math.log10(num[i]);
            long remain = num[i] % k;
            HashSet<Integer> set = map[log].get(remain);
            if (set != null) {
                set.add(i);
            } else {
                map[log].put(remain, new HashSet(Arrays.asList(i)));
            }
        }

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < 10; ++j) {
                long a1 = ((num[i] % k) * ((long) Math.pow(10, j + 1) % k)) % k;
                long remain = (k - (a1 % k)) % k;
                HashSet<Integer> set = map[j].get(remain);
                if (set != null) {
                    count += set.size() - (set.contains(i) ? 1 : 0);
                }
            }
        }

        return count;
    }
}
