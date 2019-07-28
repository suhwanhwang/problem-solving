import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
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

        String readline() {
            String s = "";
            try {
                s = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return s;
        }
    }

    public static void main(String[] args) {
        if (System.getProperty("ONLINE_JUDGE") == null) {
            try {
                System.setIn(new FileInputStream("test_in_11.txt"));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return;
            }
        }

        FastReader fs = new FastReader();
        int n = fs.nextInt();
        int m = fs.nextInt();
        int k = fs.nextInt();
        //ArrayList<String> table = new ArrayList<>();
        int[][] table = new int[n][m];
        for (int i = 0; i < n; ++i) {
            String s = fs.readline();
            for (int j = 0; j < s.length(); ++j) {
                table[i][j] = Character.getNumericValue(s.charAt(j));
            }
        }
        System.out.println(solve(table, k));
    }

    private static int solve(int[][] table, int skip) {
        for (int k = 0; k < skip; ++k) {
            int hourMax = 0;
            int max_n = -1;
            int max_m = -1;
            for (int i = 0; i < table.length; ++i) {
                int start = getStart(table[i]);
                int end = getEnd(table[i]);

                if (start == -1) {
                    // no lesson
                    continue;
                }

                int nextStart = getNextStart(table[i], start);
                if (nextStart == -1) {
                    // one lesson
                    if (hourMax < 1) {
                        max_n = i;
                        max_m = start;
                        hourMax = 1;
                    }
                    continue;
                }
                int nextEnd = getNextEnd(table[i], end);

                if (end == nextStart && nextEnd == start) {
                    if (hourMax < end - start) {
                        max_n = i;
                        max_m = start;
                        hourMax = end - start;
                    }
                } else if (nextStart - start > end - nextEnd) {
                    if (hourMax < nextStart - start) {
                        max_n = i;
                        max_m = start;
                        hourMax = nextStart - start;
                    }
                } else {
                    if (hourMax < end - nextEnd) {
                        max_n = i;
                        max_m = end;
                        hourMax = end - nextEnd;
                    }
                }
            }
            if (max_n != -1 && max_n != -1) {
                table[max_n][max_m] = 0;
            }
        }
        return getHour(table);
    }

    private static int getStart(int[] table) {
        for (int i = 0;i < table.length; ++i) {
            if (table[i] == 1) {
                return i;
            }
        }
        return -1;
    }

    private static int getEnd(int[] table) {
        for (int i = table.length - 1; i >= 0; --i) {
            if (table[i] == 1) {
                return i;
            }
        }
        return -1;
    }

    private static int getNextStart(int[] table, int start) {
        for (int j = start + 1; j < table.length; ++j) {
            if (table[j] == 1) {
                return j;
            }
        }
        return -1;
    }

    private static int getNextEnd(int[] table, int end) {
        for (int j = end - 1; j >= 0; --j) {
            if (table[j] == 1) {
                return j;
            }
        }
        return -1;
    }


    private static int getHour(int[][] table) {
        int hour = 0;
        for (int n = 0; n < table.length; ++n) {
            int start = -1;
            int end = -1;
            for (int m = 0; m < table[n].length; ++m) {
                if (table[n][m] == 1) {
                    if (start == -1) {
                        start = m;
                    }

                    end = m;
                }
            }
            if (start != -1 && end != -1) {
                hour += end - start + 1;
            }
        }
        return hour;
    }

}
