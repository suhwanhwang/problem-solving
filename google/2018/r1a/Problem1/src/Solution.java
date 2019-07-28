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
            System.out.print("Case #" + i + ": ");

            int r = fs.nextInt();
            int c = fs.nextInt();
            int h = fs.nextInt();
            int v = fs.nextInt();
            String[] waffle = new String[r];
            for (int j = 0; j < r; ++j) {
                waffle[j] = fs.next().trim();
            }

            System.out.println(solve(waffle, h, v) ? "POSSIBLE" : "IMPOSSIBLE");
        }
    }

    private static int countChoco(String[] waffle) {
        return countChoco(waffle, 0, waffle.length - 1, 0, waffle[0].length() - 1);
    }

    private static int countChoco(String[] waffle, int startR, int endR, int startC, int endC) {
        int count = 0;
        for (int i = startR; i <= endR; ++i) {
            for (int j = startC; j <= endC; ++j) {
                if (waffle[i].charAt(j) == '@') {
                    count++;
                }
            }
        }
        return count;
    }

    private static int[] getColSum(String[] waffle) {
        int[] col = new int[waffle[0].length()];

        for (int i = 0; i < waffle.length; ++i) {
            for (int j = 0; j < waffle[i].length(); ++j) {
                col[j] += (waffle[i].charAt(j) == '@' ? 1 : 0);
            }
        }
        return col;
    }

    private static int[] getCells(int[] w, int numCell, int numChoco) {
        int sum = 0;
        int count = 0;
        int[] cells = new int[numCell];
        for (int i = 0; i < w.length; ++i) {
            sum += w[i];
            if (sum > numChoco) {
                return null;
            }
            if (sum == numChoco) {
                sum = 0;
                cells[count] = i;
                count++;
            }
        }
        if (count != numCell) {
            return null;
        }
        return cells;
    }

    private static int[] getRowSum(String[] waffle) {
        int[] row = new int[waffle.length];

        for (int i = 0; i < waffle.length; ++i) {
            for (int j = 0; j < waffle[i].length(); ++j) {
                row[i] += (waffle[i].charAt(j) == '@' ? 1 : 0);
            }
        }
        return row;
    }

    private static boolean solve(String[] waffle, int h, int v) {
        int numChoco = countChoco(waffle);
        int numWaffle = (h + 1) * (v + 1);
        if (numChoco == 0) {
            return true;
        }
        if (numChoco % numWaffle != 0) {
            return false;
        }

        int chocoPerWaffle = numChoco / numWaffle;
        int chocoPerCol = chocoPerWaffle * (h + 1);
        int[] col = getColSum(waffle);
        int[] colX = getCells(col, v + 1, chocoPerCol);
        if (colX == null) {
            return false;
        }

        int chocoPerRow = chocoPerWaffle * (v + 1);
        int[] row = getRowSum(waffle);
        int[] rowY = getCells(row, h + 1, chocoPerRow);
        if (rowY == null) {
            return false;
        }

        for (int i = 0; i < colX.length; ++i) {
            int startX = (i == 0) ? 0 : colX[i - 1] + 1;
            for (int j = 0; j < rowY.length; ++j) {
                int startY = (j == 0) ? 0 : rowY[j - 1] + 1;
                int endX = colX[i];
                int endY = rowY[j];
                int choco = countChoco(waffle, startY, endY, startX, endX);
                if (choco != chocoPerWaffle) {
                    return false;
                }
            }
        }

        return true;
    }

    private static boolean solve1(String[] waffle, int h, int v) {
        int numChoco = countChoco(waffle);
        int numWaffle = (h + 1) * (v + 1);
        if (numChoco % numWaffle != 0) {
            return false;
        }

        int chocoPerWaffle = numChoco / numWaffle;

        for (int i = 0; i < waffle.length - 1; ++i) {
            for (int j = 0; j < waffle[i].length() - 1; ++j) {
                int c0 = countChoco(waffle, 0, i, 0, j);
                int c1 = countChoco(waffle, 0, i, j + 1, waffle[i].length() - 1);
                if (c0 != c1) {
                    continue;
                }

                int c2 = countChoco(waffle, i + 1, waffle.length - 1, 0, j);
                if (c0 != c2) {
                    continue;
                }
                int c3 = countChoco(waffle, i + 1, waffle.length - 1, j + 1, waffle[i].length() - 1);
                if (c0 != c3) {
                    continue;
                }
                return true;
            }
        }

        return false;
    }
}
