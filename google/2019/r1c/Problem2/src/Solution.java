import java.io.*;
import java.util.*;

public class Solution {

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        FastReader() {
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
        int t = fs.nextInt();
        int f = fs.nextInt();

        for (int tt = 1; tt <= t; ++tt) {
            solve(fs, f);
        }
    }

    static void solve(FastReader fs, int f) {
        char[][] power = new char[120][];
        for (int i = 0; i < power.length; ++i) {
            power[i] = new char[5];
        }

        char[] ans = new char[5];

        // first to third
        for(int j = 0; j < 3; ++j) {
            int[] count = new int[5];
            for (int i = 0; i < 119; ++i) {
                // compare
                boolean isOk = true;
                for (int k = 0; k < j; ++k) {
                    if (ans[k] != power[i][k]) {
                        isOk = false;
                        break;
                    }
                }
                if (!isOk) {
                    continue;
                }

                int index = i * 5 + j + 1;
                System.out.println(index);
                System.out.flush();

                power[i][j] = fs.next().charAt(0);
                count[power[i][j] - 'A']++;
            }

            int fullCount = 1;
            for (int i = 1; i < 5 - j; ++i) {
                fullCount *= i;
            }
            for (int i = 0; i < 5; ++i) {
                if (0 < count[i] && count[i] < fullCount) {
                    ans[j] = (char)('A' + i);
                    break;
                }
            }
        }

        // fourth
        for (int i = 0; i < 119; ++i) {
            if (power[i][0] != ans[0] || power[i][1] != ans[1] || power[i][2] != ans[2]) {
                continue;
            }

            int index = i * 5 + 4;
            System.out.println(index);
            System.out.flush();

            power[i][3] = fs.next().charAt(0);
            ans[4] = power[i][3];
            ans[3] = (char)(('A' + 'B' + 'C' + 'D' + 'E') - (ans[0] + ans[1] + ans[2] + ans[4]));
            break;
        }

        for (char c : ans) {
            System.out.print(c);
        }
        System.out.println();
        System.out.flush();

        String out = fs.next();
        if (out.charAt(0) == 'N') {
            System.exit(0);
        }
    }
}
