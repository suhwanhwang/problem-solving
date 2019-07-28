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
        int c = fs.nextInt();
        int m = fs.nextInt();
        Item[] items = new Item[m];
        for (int i = 0; i < m; ++i) {
            int s = fs.nextInt();
            int e = fs.nextInt();
            int b = fs.nextInt();
            items[i] = new Item(s, e, b);
        }

        System.out.println(solve(n, c, items));
    }

    static class Item implements Comparable<Item> {
        int start;
        int end;
        int box;

        public Item(int s, int e, int b) {
            start = s;
            end = e;
            box = b;
        }

        @Override
        public int compareTo(Item o) {
            if (end == o.end) {
                return start - o.start;
            }
            return end - o.end;
        }

        @Override
        public String toString() {
            return start + " " + end + " " + box;
        }
    }
    
    /*
4 40
6
3 4 20
1 2 10
1 3 20
1 4 30
2 3 10
2 4 20
    */

    static int solve(int n, int c, Item[] items) {
        int ans = 0;
        int[] loaded = new int[n + 1];

        Arrays.sort(items);

        for (int i = 0; i < items.length; ++i) {
            Item item = items[i];
            
            int prev = 0;
            for (int j = item.start; j < item.end; ++j) {
                prev = Math.max(loaded[j], prev);
            }
            
            int cur = Math.min(item.box, c - prev);
            for (int j = item.start; j < item.end; ++j) {
                loaded[j] += cur;
            }
            ans += cur; 
        }
        
        return ans;
    }
}
   