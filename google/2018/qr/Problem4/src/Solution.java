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
            double a = fs.nextDouble();

            System.out.println("Case #" + i + ":");

            solve(a);
        }
    }

    private static double getRotatedX(double x, double y, double angle) {
        return x * Math.cos(angle) - y * Math.sin(angle);
    }

    private static double getRotatedY(double x, double y, double angle) {
        return y * Math.cos(angle) + x * Math.sin(angle);
    }
    private static int solve(double a) {
        double line = Math.sqrt(1.0 + 1.0);
        double angle = Math.acos(a / line) - Math.PI / 4;

        System.out.println(String.format("%.10f %.10f 0.0", getRotatedX(0.0, 0.5, angle), getRotatedY(0.0, 0.5, angle)));
        System.out.println(String.format("%.10f %.10f 0.0", getRotatedX(-0.5, 0.0, angle), getRotatedY(-0.5, 0.0, angle)));
        System.out.println("0.0 0.0 0.5");
        return 0;
    }
}
