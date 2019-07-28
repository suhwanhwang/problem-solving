import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

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

    public static void main(String[] args) {
	// write your code here
        InputReader in = new InputReader();
        int n = in.nextInt();
        int L = in.nextInt();
        int a = in.nextInt();
        int[] t = new int[n];
        int[] l = new int[n];
        for (int i = 0; i < n; ++i) {
            t[i] = in.nextInt();
            l[i] = in.nextInt();
        }


//        boolean[] customer = new boolean[L];
//        for (int i = 0; i < n; ++i) {
//            for (int j = t[i]; j < t[i] + l[i]; ++j) {
//                customer[j] = true;
//            }
//        }
//
//        int count = 0;
//        int internal = 0;
//        for (int i = 0; i < L; ++i) {
//            if (customer[i]) {
//                internal = 0;
//            } else {
//                internal++;
//                if (internal == a) {
//                    count++;
//                    internal = 0;
//                }
//            }
//        }
//        System.out.println(count);

        int prev = -1;
        int count = 0;
        for (int i = 0; i < n; ++i) {
            count += ((t[i] - 1) - prev) / a;
            prev = t[i] + l[i] - 1;
        }
        count += ((L - 1) - prev) / a;
        System.out.println(count);
    }
}
