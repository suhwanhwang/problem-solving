import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    static class InputReader {
        private final BufferedReader br;
        private StringTokenizer st;

        public InputReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public String next() {
            while(st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }

    static class Coffee implements Comparable<Coffee>{
        int time;
        int index;
        Coffee(int t, int i) {
            time = t;
            index = i;
        }

        @Override
        public int compareTo(Coffee o) {
            return time - o.time;
        }
    }

    public static void main(String[] args) {
	// write your code here
        InputReader in = new InputReader();
        int n = in.nextInt();
        int m = in.nextInt();
        int d = in.nextInt();
        TreeSet<Coffee> set = new TreeSet<>();
        for (int i = 0; i < n; ++i) {
            int a = in.nextInt();
            set.add(new Coffee(a, i));
        }

        int[] ans = new int[n];
        int day = 0;

        while(!set.isEmpty()) {
            day++;
            for (Coffee c = set.first(); c != null; c = set.ceiling(new Coffee(c.time + d + 1, 0))) {
                ans[c.index] = day;
                set.remove(c);
            }
        }

        System.out.println(day);
        for (int i = 0; i < n; ++i) {
            System.out.print(ans[i] + " ");
        }
    }
}
