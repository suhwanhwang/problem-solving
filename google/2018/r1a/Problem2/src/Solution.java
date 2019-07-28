import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.StringTokenizer;

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

    static class Casher implements Comparable<Casher> {
        int m;
        int s;
        int p;

        Casher(int m, int s, int p) {
            this.m = m;
            this.s = s;
            this.p = p;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Casher) {
                Casher c = (Casher) obj;
                return (c.m == m && c.s == s && c.p == p);
            }
            return false;
        }

        @Override
        public int hashCode() {
            return Objects.hash(m, s, p);
        }

        @Override
        public int compareTo(Casher o) {
            return (int) ((double) (m * s + p) / m - (double) (o.m * o.s + o.p) / o.m);
        }

        public int getTime(int n) {
            return s * n + p;
        }
    }

    public static void main(String[] args) {
        if (true) {
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
            int r = fs.nextInt();
            int b = fs.nextInt();
            int c = fs.nextInt();
            Casher[] cashers = new Casher[c];
            for (int j = 0; j < c; ++j) {
                int m = fs.nextInt();
                int s = fs.nextInt();
                int p = fs.nextInt();
                cashers[j] = new Casher(m, s, p);
            }

            System.out.print("Case #" + i + ": ");
            System.out.println(solve(r, b, cashers));
        }
    }

    private static int s_numRobot;
    private static Casher[] s_Cashers;
    private static int[] s_work;

    private static int calculateTime() {
        int time = 0;
        int numRobot = 0;
        for (int i = 0; i < s_work.length; ++i) {
            if (s_work[i] == 0) {
                continue;
            }

            numRobot++;
            int turn = (s_work[i] / s_Cashers[i].m) + ((s_work[i] % s_Cashers[i].m) > 0 ? 1 : 0);
            int t = s_Cashers[i].s * s_work[i] + s_Cashers[i].p * turn;
            if (time < t) {
                time = t;
            }
        }
        return (numRobot <= s_numRobot) ? time : Integer.MAX_VALUE;
    }

    private static int solveSub(int remainBit, int casher) {
        if (remainBit == 0) {
            // end of work
            return calculateTime();
        }

        if (casher >= s_Cashers.length) {
            return Integer.MAX_VALUE;
        }

        int minTime = Integer.MAX_VALUE;

        for (int i = 0; i <= remainBit; ++i) {
            s_work[casher] = i;
            int ret = solveSub(remainBit - i, casher + 1);
            s_work[casher] = 0;

            if (ret < minTime) {
                minTime = ret;
            }
        }
        return minTime;
    }

    private static int solve1(int r, int b, Casher[] cashers) {
        s_Cashers = cashers;
        s_numRobot = r;
        s_work = new int[cashers.length];
        return solveSub(b, 0);
    }

    private static int getMaxTime(Casher[] cashers, int bit) {
        int maxS = 0;
        int maxP = 0;

        for (Casher c : cashers) {
            if (c.s > maxS) {
                maxS = c.s;
            }

            if (c.p > maxP) {
                maxP = c.p;
            }
        }
        return maxS * bit + maxP;
    }


    private static int getBitInTime(Casher c, int bit) {
        return Math.max(0, Math.min(c.m, (int)Math.floor((double)(bit - c.p)/c.s)));
    }

    private static int s_Time = 0;
    private static Comparator<Casher> s_CasherComparator = new Comparator<Casher>() {
        @Override
        public int compare(Casher o1, Casher o2) {
            return -(getBitInTime(o1, s_Time) - getBitInTime(o2, s_Time));
        }
    };

    private static boolean checkTime(Casher[] cashers, int r, int b) {
        int remainBit = b;
        for (int i = 0; i < r; ++i) {
            remainBit -= getBitInTime(cashers[i], s_Time);
        }
        return remainBit <= 0;
    }

    private static int solve(int r, int b, Casher[] cashers) {
        int maxTime = getMaxTime(cashers, b);
        int low = 0;
        int high = maxTime;

        while (low < high) {
            int mid = (low + high) >>> 1;
            s_Time = mid;
            Arrays.sort(cashers, s_CasherComparator);
            if (checkTime(cashers, r, b)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}
