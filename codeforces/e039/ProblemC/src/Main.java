import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
        FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
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

        String readline() {
            String s = "";
            try {
                s = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return s;
        }
    }

    static String solve(String s) {
        if (s.length() < 26) {
            return "-1";
        }

        char[] ans = s.toCharArray();

        char cur = 'a';
        boolean isOK = false;
        for (int i = 0; i < ans.length; ++i) {
            if (ans[i] <= cur) {
                ans[i] = cur;
                if (cur < 'z') {
                    cur++;
                } else {
                    isOK = true;
                }
            }
        }
        if (isOK) {
            return new String(ans);
        } else {
            return "-1";
        }
    }

    public static void main(String[] args) {
        if (System.getProperty("ONLINE_JUDGE") == null) {
            try {
                System.setIn(new FileInputStream("test_in.txt"));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return;
            }
        }

        FastReader fs = new FastReader();

        String s = fs.next();
        System.out.println(solve(s));
    }
}
