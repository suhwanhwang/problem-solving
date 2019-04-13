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
            System.out.print("Case #" + ca + ": ");

            int r = fs.nextInt();
            int c = fs.nextInt();

            solve(r, c);
        }
    }

    static void solve(int r, int c) {
        sFinished = false;
        for (int row = 1; row <= r; ++row) {
            for (int col = 1; col <= c; ++col) {
                if (sFinished) {
                    break;
                }
                LinkedHashSet<Point> order = new LinkedHashSet<>();
                Point p = new Point(row, col);
                order.add(p);
                solveSub(r, c, order, p);
            }
        }
        if (!sFinished) {
            System.out.println("IMPOSSIBLE");
        }
    }

    static boolean sFinished = false;

    static void solveSub(int r, int c, Set<Point> order, Point cur) {
        if (sFinished) {
            return;
        }

        if (order.size() == r * c) {
            System.out.println("POSSIBLE");
            for (Point point : order) {
                System.out.println(point);
            }
            sFinished = true;
            return;
        }

        for (int row = 1; row <= r; ++row) {
            if (row == cur.row) {
                continue;
            }

            for (int col = 1; col <= c; ++col) {
                if (col == cur.col
                || row - col == cur.row - cur.col
                || row + col == cur.row + cur.col) {
                    continue;
                }

                Point next = new Point(row, col);

                if (!order.contains(next)) {
                    order.add(next);
                    solveSub(r, c, order, next);
                    order.remove(next);
                }
            }
        }
    }

    static class Point {
        int row;
        int col;
        Point(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public String toString() {
            return row + " " + col;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, col);
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Point) {
                Point o = (Point)obj;
                return row == o.row && col == o.col;
            }
            return false;
        }
    }
}
