import java.io.*;
import java.util.*;

public class Main {
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
        FastReader fs = new FastReader();

        int n = fs.nextInt();
        Interval[] meetings = new Interval[n];
        for (int i = 0; i < n; ++i) {
            int start = fs.nextInt();
            int end = fs.nextInt();
            meetings[i] = new Interval(start, end);
        }

        System.out.println(solve(meetings));
    }

    static int solve(Interval[] meetings) {
        Arrays.sort(meetings);

        int count = 0;
        int cur = -1;
        for (int i = 0; i < meetings.length; ++i) {
            if (meetings[i].start >= cur) {
                count++;
                cur = meetings[i].end;
            }
        }

        return count;
    }

    static class Interval implements Comparable<Interval> {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "(" + start + ", " + end + ")";
        }

        @Override
        public int compareTo(Interval o) {
            if (end == o.end) {
                return start - o.start;
            }
            return end - o.end;
        }
    }
}

