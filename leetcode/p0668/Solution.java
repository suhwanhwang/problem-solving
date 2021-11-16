// https://leetcode.com/problems/kth-smallest-number-in-multiplication-table/description/
class Solution {
    public int findKthNumber(int m, int n, int k) {
        int[] all = new int[m*n];
        int index = 0;
        for(int i = 1; i <= m; ++i) {
            for(int j = 1; j <= n; ++j) {
                all[index++] = i * j;
            }
        }
        Arrays.sort(all);
        //for(int num : all)
        //    System.out.println(num);
        return all[k-1];
    }
    
    public int findKthNumber(int m, int n, int k) {
        int lo = 0;
        int hi = m*n;
        
        while (lo < hi) {
            int mid = (lo + hi) >>> 1;
            int count = getSmallNumberCount(mid, m,n);
            if (count >= k) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }
    
    private int getSmallNumberCount(int num, int m, int n) {
        int count = 0;
        for(int i = 1; i <= m; ++i) {
            count += num / i > n ? n : num / i;
        }
        return count;
    }
}
