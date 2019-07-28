import java.io.*;
import java.util.HashSet;
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
        if (true) {
            try {
                System.setIn(new FileInputStream(new File("test_in.txt")));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return;
            }
        }

//        for (int i = 0; i < 100; ++i) {
//            test();
//        }


        FastReader fs = new FastReader();
        int t = fs.nextInt();
        for (int i = 1; i <= t; ++i) {
            System.out.print("Case #" + i + ": ");

            int n = fs.nextInt();
            int l = fs.nextInt();
            String[] word = new String[n];
            for (int j = 0; j < n; ++j) {
                word[j] = fs.next().trim();
            }

            String ans = solve(word, n, l);

            System.out.println(ans == null ? "-" : ans);
        }
    }

    private static void test() {
        int n = 2000;
        int l = 10;
        Random random = new Random();
        String[] word = new String[2000];
        for (int i = 0; i < 2000; ++i) {
            StringBuilder s = new StringBuilder();
            for (int j = 0; j < 10; ++j) {
                s.append((char)(random.nextInt('Z' - 'A') + 'A'));
            }
            word[i] = s.toString();
        }

        System.out.println(solve(word, 2000, 10));
    }

    private static String solveSub(HashSet<String> hashSet, int[] letter, int l, StringBuilder s) {
        if (s.length() == l) {
            if (hashSet.contains(s.toString()) == false) {
                return s.toString();
            } else {
                return null;
            }
        }

        for (char c = 'A'; c <= 'Z'; ++c) {
            int index = s.length();
            if ((letter[index] & (1 << (c - 'A'))) != 0) {
                s.append(c);
                String ans = solveSub(hashSet, letter, l, s);
                if (ans != null) {
                    return ans;
                }
                s.deleteCharAt(index);
            }
        }
        return null;
    }

    private static String solve(String[] word, int n, int l) {
        HashSet<String> hashSet = new HashSet<>();
        int[] letter = new int[l];

        for (int i = 0; i < word.length; ++i) {
            hashSet.add(word[i]);
            for(int j = 0; j < l; ++j) {
                char c = word[i].charAt(j);
                letter[j] |= (1 <<(c - 'A'));
            }
        }
        return solveSub(hashSet, letter, l, new StringBuilder());
    }
}
