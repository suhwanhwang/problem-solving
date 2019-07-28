import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

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

        if (false) {
            System.out.println("start test");
            for (int i = 0; i < 10000; ++i) {
                int v[] = makeTestSet();
                //System.out.println(solve(v));
                if (solve1(v) != solve(v)) {
                    System.out.println("ERROR!!");
                }
            }
        }


        FastReader fs = new FastReader();
        int t = fs.nextInt();
        for (int i = 1; i <= t; ++i) {
            int n = fs.nextInt();
            int[] v = new int[n];
            for (int j = 0; j < n; ++j) {
                v[j] = fs.nextInt();
            }

            System.out.print("Case #" + i + ": ");

            int ans = solve(v);
            System.out.println(ans == -1 ? "OK" : ans);
        }
    }

    private static int[] makeTestSet() {
        Random random = new Random();
        //int num = random.nextInt(98) + 3;
        int num = 1000;
        int[] test = new int[num];
        for (int i = 0; i < num; ++i) {
            test[i] = random.nextInt(1000000000);
        }
        return test;
    }

    private static void troubleSort(int[] v) {
        /*
        TroubleSort(L): // L is a 0-indexed list of integers
            let done := false
            while not done:
              done = true
              for i := 0; i < len(L)-2; i++:
                if L[i] > L[i+2]:
                  done = false
                  reverse the sublist from L[i] to L[i+2], inclusive
         */

        boolean done = false;
        while (!done) {
            done = true;
            for (int i = 0; i < v.length - 2; ++i) {
                if (v[i] > v[i + 2]) {
                    done = false;
                    int temp = v[i];
                    v[i] = v[i + 2];
                    v[i + 2] = temp;
                }
            }
        }
    }

    private static int solve1(int[] v) {
        int[] trouble = Arrays.copyOf(v, v.length);
        int[] normal = Arrays.copyOf(v, v.length);
        troubleSort(trouble);
        Arrays.sort(normal);
        for (int i = 0; i < normal.length; ++i) {
            if (trouble[i] != normal[i]) {
                return i;
            }
        }

        return -1;
    }

    private static int solve(int[] v) {
        int len = v.length;
        int even[] = new int[len / 2 + len % 2];
        int odd[] = new int[len / 2];
        for (int i = 0; i < len; ++i) {
            if (i % 2 == 0) {
                even[i / 2] = v[i];
            } else {
                odd[i / 2] = v[i];
            }
        }
        Arrays.sort(even);
        Arrays.sort(odd);

        for (int i = 0; i < len; ++i) {
            int index = i / 2;
            if (i % 2 == 0) {
                if (index < odd.length && even[index] > odd[index]) {
                    return i;
                }
            } else {
                if (index + 1 < even.length && odd[index] > even[index + 1]) {
                    return i;
                }
            }
        }
        return -1;
    }
}
