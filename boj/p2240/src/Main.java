import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
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
    }

    static int T,W;
    static int[] TREE;
    static int[][][] CACH;

    public static void main(String[] args) {
        // write your code here
        InputReader in = new InputReader();
        T = in.nextInt();
        W = in.nextInt();
        TREE = new int[T];

        for (int i = 0; i < T; ++i) {
            TREE[i] = in.nextInt();
        }

        System.out.println(solve());
    }

    static int solve() {
        CACH = new int[T + 1][W + 1][2 + 1];
        for (int i = 0; i < CACH.length; ++i) {
            for (int j = 0; j < CACH[i].length; ++j) {
                Arrays.fill(CACH[i][j], -1);
            }
        }
        return solveSub(0, W, 1);
    }

    static int solveSub(int time, int w, int pos) {
        if(time == T) {
            return 0;
        }

        if (CACH[time][w][pos] >= 0) {
            return CACH[time][w][pos];
        }

        int max = Integer.MIN_VALUE;

        if (w > 0) {
            max = solveSub(time + 1, w - 1, (pos%2)+1) + (TREE[time] == pos ? 0 : 1);
        }
        max = Math.max(max, solveSub(time+1,w,pos)) + (TREE[time] == pos ? 1:0);
        CACH[time][w][pos] = max;
        return max;
    }
}