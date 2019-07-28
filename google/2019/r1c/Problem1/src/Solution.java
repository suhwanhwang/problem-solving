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
        if ("true".equals(System.getProperty("use_text_input"))) {
            try {
                System.setIn(new FileInputStream(new File("test_in.txt")));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return;
            }
        }


        FastReader fs = new FastReader();
        int t = fs.nextInt();
        for (int ca = 1; ca <= t; ++ca) {
            int a = fs.nextInt();
            String[] c = new String[a];
            for (int i = 0; i < a; ++i) {
                c[i] = fs.next().trim();
            }

            System.out.print("Case #" + ca + ": ");
            solve(c);
        }
    }

    static void solve(String[] c) {
        String ans = null;
        Set<String> cSet = new HashSet<>();
        for (String s : c) {
            cSet.add(s);
        }

        for (char next : RSP) {
            ans = solveSub(cSet, "" + next);
            if (ans != null) {
                break;
            }
        }

        if (ans == null) {
            System.out.println("IMPOSSIBLE");
        } else {
            System.out.println(ans);
        }
    }

    static final int MAX_LEN = 500;
    static final char[] RSP = {'R', 'S', 'P'};

    static String solveSub(Set<String> c, String s) {
        int len = s.length();
        if (len > MAX_LEN) {
            return null;
        }

        Set<String> win = new HashSet<>();
        for (String a : c) {
            int modIndex = (len - 1) % a.length();
            if (isBeat(a.charAt(modIndex), s.charAt(len - 1))) {

            } else if (isWin(a.charAt(modIndex), s.charAt(len - 1))) {
                win.add(a);
            } else {
                return null;
            }
        }


        Set<String> remain = new HashSet<>(c);
        remain.removeAll(win);
        if (remain.isEmpty()) {
            return s;
        } else {
            for (char next : RSP) {
                String s1 = solveSub(remain, s + next);
                if (s1 != null) {
                    return s1;
                }
            }
        }
        return null;
    }

    static boolean isBeat(char c1, char c2) {
        return c1 == c2;
    }

    static boolean isWin(char c1, char c2) {
        switch (c1) {
            case 'R':
                return c2 == 'P';
            case 'S':
                return c2 == 'R';
            case 'P':
                return c2 == 'S';
        }
        return false;
    }
}
