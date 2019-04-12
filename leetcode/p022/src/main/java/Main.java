import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Main {
    static class InputReader {
        BufferedReader br;
        StringTokenizer st;

        public InputReader() {
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
    
    static class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> ans = new ArrayList<>();
            generateSub(ans, n, 0, "");
            return ans;
        }
        private void generateSub(List<String> ans, int n, int left, String s) {
            if (s.length() == 2*n) {
                ans.add(s);
                return;
            }
            
            int right = s.length() - left;
            if (left > right) {
                String next = s + ")";
                generateSub(ans, n, left, next);
            }
            
            String next = s + "(";
            generateSub(ans, n, left + 1, next);
        }
    }

    public static void main(String[] args) {
        // write your code here
        int k = 3;
        Solution s = new Solution();
        System.out.println(s.topKFrequent(k));
    }
}
