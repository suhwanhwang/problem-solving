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
        if (false) {
            try {
                System.setIn(new FileInputStream(new File("test_in.txt")));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return;
            }
        }

        FastReader fs = new FastReader();
        int n = fs.nextInt();
        int[] l = new int[n];
        int[] r = new int[n];
        for (int i = 0; i < n; ++i) {
            l[i] = fs.nextInt();
            r[i] = fs.nextInt();
        }

        /* O (n * n)
        int max = 0;
        for (int i = 0; i < n; ++i) {
            int start = 0;
            int end = 1000000000;
            for (int j = 0; j < n; ++j) {
                if (j == i) {
                    continue;
                }
                start = Math.max(start, l[j]);
                end = Math.min(end, r[j]);
            }
            max = Math.max(max, end - start);
        }
        */

        /* O(n log n)
        TreeMap<Integer, Integer> startMap = new TreeMap<>();
        TreeMap<Integer, Integer> endMap = new TreeMap<>();
        for (int i = 0; i < n; ++i) {
            startMap.put(l[i], startMap.containsKey(l[i]) ? startMap.get(l[i]) + 1 : 1);
            endMap.put(r[i], endMap.containsKey(r[i]) ? endMap.get(r[i]) + 1 : 1);
        }
        int max = 0;
        for (int i = 0; i < n; ++i) {
            int start = startMap.lastKey();
            int end = endMap.firstKey();
            if (l[i] == start) {
                int v = startMap.get(start);
                if (v == 1) {
                    startMap.remove(start);
                    start = startMap.lastKey();
                    startMap.put(l[i], 1);
                }
            }

            if (r[i] == end) {
                int v = endMap.get(end);
                if (v == 1) {
                    endMap.remove(end);
                    end = endMap.firstKey();
                    endMap.put(r[i], 1);
                }
            }

            max = Math.max(max, end - start);
        }
        */

        // O(n)
        int[] prl = new int[n + 1];
        int[] sul = new int[n + 1];

        int[] prr = new int[n + 1];
        int[] sur = new int[n + 1];

        prl[0] = sul[n] = 0;
        prr[0] = sur[n] = Integer.MAX_VALUE;
        for (int i = 0; i < n; ++i) {
            prl[i + 1] = Math.max(prl[i], l[i]);
            prr[i + 1] = Math.min(prr[i], r[i]);
        }

        for (int i = n - 1; i >= 0; --i) {
            sul[i] = Math.max(sul[i + 1], l[i]);
            sur[i] = Math.min(sur[i + 1], r[i]);
        }

        int max = 0;
        for (int i = 0; i < n; ++i) {
            int lmax = Math.max(prl[i], sul[i + 1]);
            int rmin = Math.min(prr[i], sur[i + 1]);
            max = Math.max(max, rmin - lmax);
        }

        System.out.println(max);
    }
}
