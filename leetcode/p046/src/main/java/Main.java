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
        static class Item implements Comparable<Item>{
            int num;
            int count;
            public Item(int n, int c) {
             num = n;
             count = c;
            }
            
            @Override
            public int compareTo(Item p) {
                return -(count - p.count);
            }
        }
        
        public List<Integer> topKFrequent(int[] nums, int k) {
            List<Integer> ans = new ArrayList<>();
            HashMap<Integer, Integer> map= new HashMap<>();
            for (int num : nums) {
                Integer count = map.get(num);
                if (count == null) {
                    map.put(num, 1);
                } else {
                    map.put(num, count+1);
                }
            }
            
            PriorityQueue<Item> pq=new PriorityQueue<>();
            for (Integer num : map.keySet()) {
                pq.add(new Item(num, map.get(num)));
            }
            
            for(int i = 0; i < k; ++i){
                Item item = pq.poll();
                ans.add(item.num);
            }
            
            return ans;
        }
    }

    public static void main(String[] args) {
        // write your code here
        int[]nums ={1,1,1,2,2,3};
        int k = 2;
        Solution s = new Solution();
        System.out.println(s.topKFrequent(nums, k));
    }
}
