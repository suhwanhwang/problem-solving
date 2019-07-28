import java.io.*;
import java.util.*;

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
        Random random = new Random();

        int t = fs.nextInt();
        for (int i = 1; i <= t; ++i) {
            int n = fs.nextInt();
            boolean[] sold = new boolean[n];

            for (int j = 0; j < n; ++j) {
                int d = fs.nextInt();
                int[] like = new int[d];
                HashSet<Integer> hashSet = new HashSet<>();

                for (int k = 0; k < d; ++k) {
                    like[k] = fs.nextInt();
                    hashSet.add(like[k]);
                }

                boolean isOK = false;
//                for (int k = 0; k < d; ++k) {
//                    if (sold[like[k]] == false) {
//                        sold[like[k]] = true;
//                        System.out.println(like[k]);
//                        System.out.flush();
//                        isOK = true;
//                        break;
//                    }
//                }
                while (!hashSet.isEmpty()) {
                    int k = random.nextInt(d);
                    if (sold[like[k]] == false) {
                        sold[like[k]] = true;
                        System.out.println(like[k]);
                        System.out.flush();
                        isOK = true;
                        break;
                    }
                    hashSet.remove(like[k]);
                }

                if (!isOK) {
                    System.out.println("-1");
                    System.out.flush();
                }
            }

        }
    }
}
