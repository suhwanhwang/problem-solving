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
        int n = fs.nextInt();
        int k = fs.nextInt();
        String s = fs.next();
        int sameIndex = s.length();
        for (int i = 1; i < s.length(); ++i) {
            String substring = s.substring(i);
            if (substring.equals(s.substring(0, s.length() - i))) {
                sameIndex = i;
                break;
            }
        }
        String ans = new String(s);
        for (int i = 1; i < k; ++i) {
            ans += s.substring(s.length() - sameIndex);
        }
        System.out.println(ans);
    }
}
