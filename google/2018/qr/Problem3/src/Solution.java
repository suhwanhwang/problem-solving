import java.io.*;
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
        int t = fs.nextInt();
        for (int i = 1; i <= t; ++i) {
            int a = fs.nextInt();
            int remain = a;
            boolean[][] soil = new boolean[1000][1000];

            // first
            int targetX = 2;
            int targetY = 2;

            System.out.println(targetX + " " + targetY);
            System.out.flush();
            while(true) {
                int x = fs.nextInt();
                int y = fs.nextInt();

                if (x == 0 && y == 0) {
                    // solve
                    break;
                }

                if (x == -1 && y == -1) {
                    // failed
                    return;
                }

                soil[y][x] = true; // prepared
                if (check9block(soil, targetX, targetY)) {
                    remain -= 9;
                    if (remain <= 3) {
                        targetX += 1;
                    } else if (remain <= 6) {
                        targetX += 2;
                    } else {
                        targetX += 3;
                    }
                }
                System.out.println(targetX + " " + targetY);
                System.out.flush();
            }
        }
    }

    static boolean check9block(boolean[][] soil, int targetX, int targetY) {
        int count = 0;
        for (int x = targetX - 1; x <= targetX + 1; ++x) {
            for (int y = targetY - 1; y <= targetY + 1; ++y) {
                if (soil[y][x]) {
                    count++;
                }
            }
        }
        return count == 9;
    }
}
