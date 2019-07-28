import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
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
        int n = fs.nextInt();
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            int d = fs.nextInt();
            arrayList.add(d);
        }

        int max = 0;
        for (int i = 0; i < n; ++i) {
            int first = arrayList.get(i);
            int last = first * 2;
            int beforeIndex;
            int lastIndex = i;
            do {
                beforeIndex = lastIndex;
                lastIndex = Collections.binarySearch(arrayList, last);
                if (lastIndex < 0) {
                    lastIndex = -(lastIndex + 1) - 1;
                }
                last = arrayList.get(lastIndex) * 2;
            } while (lastIndex > beforeIndex);

            max = Math.max(max, lastIndex - i + 1);
        }

        System.out.println(max);
    }
}
