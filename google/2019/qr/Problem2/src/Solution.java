import java.io.*;
import java.util.HashMap;
import java.util.Objects;
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

        //generatePath(10, 0, 0, "");


        FastReader fs = new FastReader();
        int t = fs.nextInt();
        for (int i = 1; i <= t; ++i) {
            int n = fs.nextInt();
            String p = fs.next();
            System.out.print("Case #" + i + ": ");

            System.out.println(solve(n, p));
        }
    }

    static class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Point) {
                Point p = (Point)obj;
                return p.x == x && p.y == y;
            }
            return false;
        }
    }

    private static void generatePath(int n, int e, int s,  String p) {
        if (e + s == 2 * n - 2) {
            //System.out.println(p);

            String ans = solve(n, p);

            HashMap<Point, Point> orgMap = new HashMap<>();
            Point cur = new Point(0, 0);
            for (int i = 0; i < p.length(); ++i) {
                Point next;
                if (p.charAt(i) == 'E') {
                    next = new Point(cur.x + 1, cur.y);
                } else {
                    next = new Point(cur.x, cur.y + 1);
                }
                orgMap.put(cur, next);
                cur = next;
            }


            cur = new Point(0, 0);
            for (int i = 0; i < ans.length(); ++i) {
                Point next;
                if (ans.charAt(i) == 'E') {
                    next = new Point(cur.x + 1, cur.y);
                } else {
                    next = new Point(cur.x, cur.y + 1);
                }
                Point tmp = orgMap.get(cur);
                if (tmp != null && tmp.equals(next)) {
                    System.out.println("error: " + p);
                    break;
                }

                cur = next;
            }


        }

        if (e < n - 1) {
            generatePath(n, e + 1, s, p + "E");
        }
        if (s < n - 1) {
            generatePath(n, e, s + 1, p + "S");
        }
    }

    private static String solve(int n, String p) {
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < p.length(); ++i) {
            if (p.charAt(i) == 'E') {
                ans.append('S');
            } else {
                ans.append('E');
            }
        }
        return ans.toString();
    }
}
