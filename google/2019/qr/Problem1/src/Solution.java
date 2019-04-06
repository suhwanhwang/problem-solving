import java.io.*;
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


        FastReader fs = new FastReader();
        int t = fs.nextInt();
        for (int i = 1; i <= t; ++i) {
            String n = fs.next();

            System.out.print("Case #" + i + ": ");

            solve(n);
        }
    }

    private static void solve(String n) {
        StringBuilder a = new StringBuilder();
        StringBuilder b = new StringBuilder();
        for (int i = 0; i < n.length(); ++i) {
            char digit = n.charAt(i);
            if (digit == '4') {
                a.append(2);
                b.append(2);
            } else {
                a.append(digit);
                if (b.length() > 0) {
                    b.append(0);
                }
            }
        }
        System.out.println(a + " " + b);
    }
}
