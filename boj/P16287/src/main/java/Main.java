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

        int w = fs.nextInt();
        int n = fs.nextInt();
        int[] parcel = new int[n];
        for (int i = 0; i < n; ++i) {
            parcel[i] = fs.nextInt();
        }

        System.out.println(solve(w, n, parcel) ? "YES" : "NO");
    }

    static boolean solve(int w, int n, int[]parcel) {
        // two sum map
        Map<Integer, List<Pair>> map = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                int sum = parcel[i] + parcel[j];
                List<Pair> list = map.get(sum);
                if (list == null) {
                    list = new ArrayList<>();
                }
                list.add(new Pair(parcel[i], parcel[j]));
                map.put(sum, list);
            }
        }
        //System.out.println(map);
        
        for (Integer num : map.keySet()) {
            List<Pair> l1 = map.get(num);
            
            int rest = w - num;
            
            List<Pair> l2 = map.get(rest);
            if (l2 != null) {
                for (Pair p1 : l1) {
                    for(Pair p2 : l2) {
                        if(p1.a != p2.a && p1.a != p2.b && p1.b != p2.a && p1.b != p2.b) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
    
    static class Pair {
        int a;
        int b;
        public Pair (int a, int b) {
            this.a = Math.min(a, b);
            this.b = Math.max(a, b);
        }
        @Override
        public int hashCode() {
            return Objects.hash(a, b);
        }
        @Override
        public boolean equals(Object o) {
            if (o instanceof Pair) {
                Pair p = (Pair)o;
                return (a == p.a && b == p.b);
            }
            return false;
        }
        @Override
        public String toString() {
            return a + "," + b;
        }
    }
}
   