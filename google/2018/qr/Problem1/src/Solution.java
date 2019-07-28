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
            int d = fs.nextInt();
            String p = fs.next();

            System.out.print("Case #" + i + ": ");

            int ans = solve(d, p);
            System.out.println(ans != -1 ? ans : "IMPOSSIBLE");
        }
    }

    private static int calculateDamage(char[] s) {
        int damage = 1;
        int total = 0;
        for (int i = 0; i < s.length; ++i) {
            if (s[i] == 'C') {
                damage *= 2;
            } else if (s[i] == 'S') {
                total += damage;
            }
        }
        return total;
    }

    private static int countShoot(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == 'S') {
                count++;
            }
        }
        return count;
    }

    private static int solve(int d, String p) {
        if (countShoot(p) > d) {
            return -1;
        }

        int hack = 0;
        char[] program = p.toCharArray();
        while(true) {
            int damage = calculateDamage(program);
            if (damage <= d) {
                return hack;
            }

            // hack
            for (int i = program.length - 1; i > 0; --i) {
                if (program[i] == 'S' && program[i - 1] == 'C') {
                    program[i] = 'C';
                    program[i - 1] = 'S';
                    hack++;
                    break;
                }
            }
        }
    }
}
